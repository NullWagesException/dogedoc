package com.dogedoc.core.analysis.path;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhengfa
 * @date 2021年05月20日 14:18:00
 * @description 路径解析默认实现类
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class DefaultAnalysisPath implements AnalysisPath {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAnalysisPath.class);

    private static final Class[] MAPPINGS = new Class[]{
            PostMapping.class,
            GetMapping.class,
            PutMapping.class,
            DeleteMapping.class,
            PatchMapping.class,
    };

    @Override
    public String analysis(ProceedingJoinPoint pjp,String path) {
        MethodSignature ms = (MethodSignature) pjp.getSignature();
        return analysisMethodPath(ms.getMethod());
    }

    private String analysisMethodPath(Method method){
        RequestMapping mapping = AnnotationUtils.findAnnotation(method, RequestMapping.class);
        if (mapping != null){
            if (mapping.path().length != 0){
                // todo 暂时只取第一个
                return mapping.path()[0];
            }
            for (Class aClass : MAPPINGS) {
                Annotation annotation = AnnotationUtils.findAnnotation(method, aClass);
                if (annotation != null){
                    Method[] declaredMethods = annotation.annotationType().getDeclaredMethods();
                    for (Method declaredMethod : declaredMethods) {
                        if (declaredMethod.getName().contains("path")){
                            try {
                                return ((String[]) declaredMethod.invoke(annotation))[0];
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                LOGGER.error("获取路径失败！",e);
                            }
                        }
                    }
                }
            }
        }
        return "/";
    }
}
