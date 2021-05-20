package com.dogedoc.core.aspect;

import com.dogedoc.core.analysis.CoreAnalysisExecutor;
import com.dogedoc.core.pojo.DogeDocDto;
import com.dogedoc.core.sender.DogeDocSenderFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhengfa
 * @date 2021年05月20日 10:51:00
 * @description
 */
@Aspect
@Component
public class DogeDocAspect {

    @Autowired
    private CoreAnalysisExecutor coreAnalysisExecutor;

    @Autowired
    private DogeDocSenderFactory dogeDocSenderFactory;

    @Pointcut("@annotation(com.dogedoc.core.annocation.DogeDoc)")
    public void DogeDoc(){

    }

    @Around("DogeDoc()")
    public Object decideAccess(ProceedingJoinPoint pjp) throws Throwable {
        DogeDocDto dogeDocDto = new DogeDocDto();
        String path = coreAnalysisExecutor.analysisPath(pjp);
        dogeDocDto.setPath(path);
        String type = coreAnalysisExecutor.analysisType(pjp);
        dogeDocDto.setType(type);
        String request = coreAnalysisExecutor.analysisRequest(pjp.getArgs());
        dogeDocDto.setRequest(request);
        Object proceed = pjp.proceed();
        String response = coreAnalysisExecutor.analysisResponse(proceed);
        dogeDocDto.setResponse(response);
        dogeDocSenderFactory.structureDoc(request,response);
        return proceed;
    }

}
