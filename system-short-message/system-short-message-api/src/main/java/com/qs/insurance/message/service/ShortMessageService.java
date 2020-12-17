package com.qs.insurance.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qs.insurance.message.entity.ShortMessage;
import com.qs.insurance.message.entity.ShortMessageContent;

import java.util.Map;

public interface ShortMessageService extends IService<ShortMessage> {
    Map login(String username, String password);

    String getMessageBalance();

    String getMessageCode(String projectName);

    String getMessageCodeAgain(String phoneNumber);
}
