package com.qs.insurance.message.service;

public interface ShortMessageService {
    String login(String username, String password);

    String getMessageBalance();

    String getMessageCode(String projectName);

    String getMessageCodeAgain(String phoneNumber);
}
