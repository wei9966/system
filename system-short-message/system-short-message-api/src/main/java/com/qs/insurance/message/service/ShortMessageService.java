package com.qs.insurance.message.service;

import java.util.Map;

public interface ShortMessageService {
    Map login(String username, String password);

    String getMessageBalance();

    String getMessageCode(String projectName);

    String getMessageCodeAgain(String phoneNumber);
}
