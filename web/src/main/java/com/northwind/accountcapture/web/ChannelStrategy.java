package com.northwind.accountcapture.web;

/** 账户处理策略。按渠道挑一个实现。 */
public interface ChannelStrategy {

    void handle(String value);
}
