package com.qs.insurance.upms.controller.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
// topic 主题要与消息生产者一致
@RocketMQMessageListener(consumerGroup = "consumer-group", topic = "rocketmq-demo")
public class AddBonusListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String testMessaging) {
        log.warn("消费到消息 => "+testMessaging.toString());
    }
}