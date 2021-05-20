package com.dogedoc.core.analysis.param;

import com.dogedoc.core.analysis.Analysis;

/**
 * @author zhengfa
 * @date 2021年05月17日 19:57:00
 * @description 参数解析
 */
public interface AnalysisParam extends Analysis {

    String analysisRequest(Object[] args,String request);

    String analysisResponse(Object obj,String response);

}
