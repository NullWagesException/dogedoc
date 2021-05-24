package com.dogedoc.core.sender;

import com.dogedoc.core.pojo.DogeDocDto;
import org.springframework.stereotype.Component;

/**
 * @author zhengfa
 * @date 2021年05月18日 19:14:00
 * @description
 */
@Component
public class DogeDocDefaultSender implements DogeDocSenderFactory {

    @Override
    public void structureDoc(DogeDocDto dogeDocDto) {
        System.out.println(dogeDocDto);
    }
}
