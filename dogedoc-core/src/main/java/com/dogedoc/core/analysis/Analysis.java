package com.dogedoc.core.analysis;

import com.dogedoc.core.pojo.DogeDocDto;

/**
 * @author zhengfa
 * @date 2021年05月18日 20:10:00
 * @description 顶层解析接口
 */
public interface Analysis {

    ThreadLocal<DogeDocDto> data = new ThreadLocal<>();

}
