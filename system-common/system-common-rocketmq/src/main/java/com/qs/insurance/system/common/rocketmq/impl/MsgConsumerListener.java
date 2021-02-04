package com.qs.insurance.system.common.rocketmq.impl;

public interface MsgConsumerListener {
    void onMessage(String message);
}
