package com.dogedoc.core.sender;

import org.springframework.stereotype.Component;

/**
 * @author zhengfa
 * @date 2021年05月18日 19:14:00
 * @description
 */
@Component
public class DogeDocDefaultSender implements DogeDocSenderFactory {

    @Override
    public void structureDoc(String request, String response) {
        System.out.println(request);
        System.out.println(response);
    }
}
