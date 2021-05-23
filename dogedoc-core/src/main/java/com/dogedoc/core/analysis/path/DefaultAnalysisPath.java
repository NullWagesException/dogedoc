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
            RequestMapping.class,
            PostMapping.class,
            GetMapping.class,
            PutMapping.class,
            DeleteMapping.class,
            PatchMapping.class,
    };

    @Override
    public String analysis(ProceedingJoinPoint pjp,String path) {
        return analysisPath(pjp);
    }

    private String analysisPath(ProceedingJoinPoint pjp){
        String parentPath = null;
        String methodPath = null;
        StringBuilder result = new StringBuilder();
        MethodSignature ms = (MethodSignature) pjp.getSignature();
        Method method = ms.getMethod();
        try {
            Class<?> parentClass = Class.forName(pjp.getSignature().getDeclaringTypeName());
            Annotation annotation;
            for (Class aClass : MAPPINGS) {
                // 找到目标类上的路径
                annotation = AnnotationUtils.findAnnotation(parentClass, aClass);
                if (annotation != null && (parentPath = doAnalysis(annotation)) != null) {
                    result.append(parentPath);
                }
                // 找到方法上的路径
                annotation = AnnotationUtils.findAnnotation(method, aClass);
                if (annotation != null && (methodPath = doAnalysis(annotation)) != null) {
                    result.append(methodPath);
                }
                if (parentPath != null && methodPath != null){
                    return result.toString();
                }
            }
        } catch (ClassNotFoundException e) {
            LOGGER.error("获取父级路径失败！",e);
        }
        return result.toString();
    }

    private String doAnalysis(Annotation annotation){
        if (annotation != null){
            Method[] declaredMethods = annotation.annotationType().getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                if (declaredMethod.getName().contains("path")){
                    try {
                        String[] invoke = (String[]) declaredMethod.invoke(annotation);
                        return invoke.length == 0 ? null : invoke[0];
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        LOGGER.error("获取方法路径失败！",e);
                    }
                }
            }
        }
        return "/";
    }
}
