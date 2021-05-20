package com.dogedoc.core.analysis.type;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

/**
 * @author zhengfa
 * @date 2021年05月20日 14:18:00
 * @description 路径解析默认实现类
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class DefaultAnalysisType implements AnalysisType {

    @Override
    public String analysis(ProceedingJoinPoint pjp,String path) {
        MethodSignature ms = (MethodSignature) pjp.getSignature();
        Method method = ms.getMethod();
        RequestMapping mapping = AnnotationUtils.findAnnotation(method, RequestMapping.class);
        if (mapping == null || mapping.method().length == 0){
            return "/";
        }
        return mapping.method()[0].toString();
    }
}
