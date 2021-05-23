package com.dogedoc.core.analysis;

import com.alibaba.fastjson.JSON;
import com.dogedoc.core.analysis.param.AnalysisParam;
import com.dogedoc.core.analysis.path.AnalysisPath;
import com.dogedoc.core.analysis.type.AnalysisType;
import com.dogedoc.core.pojo.DogeDocDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void doAnalysis(ProceedingJoinPoint pjp, Object proceed) {
        init();
        analysisPath(pjp);
        analysisType(pjp);
        analysisRequest(pjp.getArgs());
        analysisResponse(proceed);
        clear();
    }

    public void analysisRequest(Object[] args){
        DogeDocDto dogeDocDto = analysisParams.get(0).data.get();
        Map<String,Object> request = new HashMap<>();
        for (AnalysisParam analysisParam : analysisParams) {
            request = analysisParam.analysisRequest(args,request);
        }
        dogeDocDto.setRequest(JSON.toJSONString(request));
    }

    public void analysisResponse(Object obj){
        DogeDocDto dogeDocDto = analysisParams.get(0).data.get();
        String response = null;
        for (AnalysisParam analysisParam : analysisParams) {
            response = analysisParam.analysisResponse(obj,response);
        }
        dogeDocDto.setResponse(response);
    }

    public void analysisPath(ProceedingJoinPoint pjp){
        DogeDocDto dogeDocDto = analysisParams.get(0).data.get();
        String path = null;
        for (AnalysisPath analysisPath : analysisPaths) {
            path = analysisPath.analysis(pjp,path);
        }
        dogeDocDto.setPath(path);
    }

    public void analysisType(ProceedingJoinPoint pjp){
        DogeDocDto dogeDocDto = analysisParams.get(0).data.get();
        String type = null;
        for (AnalysisType analysisType : analysisTypes) {
            type = analysisType.analysis(pjp,type);
        }
        dogeDocDto.setType(type);
    }

    public void init(){
        analysisParams.get(0).data.set(new DogeDocDto());
    }

    public void clear(){
        analysisParams.get(0).data.remove();
    }
}
