package com.dogedoc.core.analysis;

import com.dogedoc.core.analysis.param.AnalysisParam;
import com.dogedoc.core.analysis.path.AnalysisPath;
import com.dogedoc.core.analysis.type.AnalysisType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhengfa
 * @date 2021年05月18日 17:32:00
 * @description 核心解析执行器，包括解析参数、路径、描述，不提供扩展
 */
@Component
public class CoreAnalysisExecutor {

    @Autowired
    private List<AnalysisParam> analysisParams;

    @Autowired
    private List<AnalysisPath> analysisPaths;

    @Autowired
    private List<AnalysisType> analysisTypes;

    public String analysisRequest(Object[] args){
        String request = null;
        for (AnalysisParam analysisParam : analysisParams) {
            request = analysisParam.analysisRequest(args,request);
        }
        return request;
    }

    public String analysisResponse(Object obj){
        String response = null;
        for (AnalysisParam analysisParam : analysisParams) {
            response = analysisParam.analysisResponse(obj,response);
        }
        return response;
    }

    public String analysisPath(ProceedingJoinPoint pjp){
        String path = null;
        for (AnalysisPath analysisPath : analysisPaths) {
            path = analysisPath.analysis(pjp,path);
        }
        return path;
    }

    public String analysisType(ProceedingJoinPoint pjp){
        String type = null;
        for (AnalysisType analysisType : analysisTypes) {
            type = analysisType.analysis(pjp,type);
        }
        return type;
    }

}
