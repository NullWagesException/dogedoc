package com.dogedoc.core.analysis.param;

import com.dogedoc.core.analysis.Analysis;

import java.util.Map;

/**
 * @author zhengfa
 * @date 2021年05月17日 19:57:00
 * @description 参数解析
 */
public interface AnalysisParam extends Analysis {

    Map<String,Object> analysisRequest(Object[] args, Map<String,Object> request);

    String analysisResponse(Object obj,String response);

}
