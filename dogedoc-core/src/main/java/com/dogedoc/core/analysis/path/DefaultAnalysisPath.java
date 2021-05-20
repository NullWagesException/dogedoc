package com.dogedoc.core.analysis.path;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

/**
 * @author zhengfa
 * @date 2021年05月20日 14:18:00
 * @description 路径解析默认实现类
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class DefaultAnalysisPath implements AnalysisPath {


    @Override
    public String analysis(ProceedingJoinPoint pjp,String path) {
        MethodSignature ms = (MethodSignature) pjp.getSignature();
        Method method = ms.getMethod();
        RequestMapping mapping = AnnotationUtils.findAnnotation(method, RequestMapping.class);
        if (mapping != null){
            PostMapping post = AnnotationUtils.findAnnotation(method, PostMapping.class);
            if (post != null){
                System.out.println("");
            }
        }
        return "/";
    }
}
