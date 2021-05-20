package com.dogedoc.core.pojo;

/**
 * @author zhengfa
 * @date 2021年05月18日 19:27:00
 * @description
 */
public class DogeDocDto {

    /**
     * 请求体
     */
    private String request;

    /**
     * 响应体
     */
    private String response;

    /**
     * 方法描述
     */
    private String methodDescribe;

    /**
     * 请求路径
     */
    private String path;

    /**
     * 请求类型
     */
    private String type;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMethodDescribe() {
        return methodDescribe;
    }

    public void setMethodDescribe(String methodDescribe) {
        this.methodDescribe = methodDescribe;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
