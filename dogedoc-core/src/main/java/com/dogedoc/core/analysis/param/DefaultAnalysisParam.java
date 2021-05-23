package com.dogedoc.core.analysis.param;


import com.alibaba.fastjson.JSON;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zhengfa
 * @date 2021年05月17日 19:57:00
 * @description 参数解析默认实现类
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class DefaultAnalysisParam implements AnalysisParam {

    @Override
    public Map<String,Object> analysisRequest(Object[] args, Map<String,Object> request){
        for (Object arg : args) {
            String jsonString = JSON.toJSONString(arg);
            request.putAll(JSON.parseObject(jsonString, Map.class));
        }
        return request;
    }

    @Override
    public String analysisResponse(Object obj,String response) {
        return JSON.toJSONString(obj);
    }
}
