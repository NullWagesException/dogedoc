package com.dogedoc.core.analysis.path;

import com.dogedoc.core.analysis.Analysis;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author zhengfa
 * @date 2021年05月17日 19:57:00
 * @description 接口路径解析
 */
public interface AnalysisPath extends Analysis {

    String analysis(ProceedingJoinPoint pjp,String path);

}
