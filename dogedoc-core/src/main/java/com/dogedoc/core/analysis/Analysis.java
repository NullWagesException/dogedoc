package com.dogedoc.core.analysis;

import com.dogedoc.core.pojo.DogeDocDto;

/**
 * @author zhengfa
 * @date 2021年05月18日 20:10:00
 * @description 顶层解析接口
 */
public interface Analysis {

    /**
     * 事实上不用ThreadLocal也没关系，我觉得在生成接口文档的时候，不会有人会同时去发两个请求……
     */
    ThreadLocal<DogeDocDto> data = new ThreadLocal<>();

}
