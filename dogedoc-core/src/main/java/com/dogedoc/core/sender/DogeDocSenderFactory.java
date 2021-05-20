package com.dogedoc.core.sender;

/**
 * @author zhengfa
 * @date 2021年05月17日 20:15:00
 * @description 将解析的参数进行页面生成的工厂类
 */
public interface DogeDocSenderFactory {

    void structureDoc(String request,String response);

}
