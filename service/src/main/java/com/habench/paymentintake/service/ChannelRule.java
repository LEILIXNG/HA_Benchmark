package com.habench.paymentintake.service;

public interface ChannelRule {
    void handle(String value);
}
