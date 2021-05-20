package com.dogedoc.core.analysis.param;


import com.alibaba.fastjson.JSON;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zhengfa
 * @date 2021年05月17日 19:57:00
 * @description 参数解析默认实现类
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class DefaultAnalysisParam implements AnalysisParam {

    @Override
    public String analysisRequest(Object[] args,String request){
        return JSON.toJSONString(args[0]);
    }

    @Override
    public String analysisResponse(Object obj,String response) {
        return JSON.toJSONString(obj);
    }
}
