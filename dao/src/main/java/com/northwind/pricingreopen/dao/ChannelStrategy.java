package com.northwind.pricingreopen.dao;

/** 定价处理策略。按渠道挑一个实现。 */
public interface ChannelStrategy {

    void handle(String value);
}
