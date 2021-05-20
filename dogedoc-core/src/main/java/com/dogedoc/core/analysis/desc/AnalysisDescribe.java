package com.dogedoc.core.analysis.desc;

import com.dogedoc.core.analysis.Analysis;

/**
 * @author zhengfa
 * @date 2021年05月17日 19:57:00
 * @description 方法描述解析
 */
public interface AnalysisDescribe extends Analysis {

    String analysis(Object[] args,String request);

}
