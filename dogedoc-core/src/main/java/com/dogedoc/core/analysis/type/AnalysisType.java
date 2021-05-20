package com.dogedoc.core.analysis.type;

import com.dogedoc.core.analysis.Analysis;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author zhengfa
 * @date 2021年05月17日 19:57:00
 * @description 请求类型解析
 */
public interface AnalysisType extends Analysis {

    String GET = "get";

    String POST = "post";

    String PUT = "post";

    String PATCH = "post";

    String DELETE = "post";


    String analysis(ProceedingJoinPoint pjp,String path);

}
