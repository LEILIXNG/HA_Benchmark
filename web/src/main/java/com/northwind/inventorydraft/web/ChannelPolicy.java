package com.northwind.inventorydraft.web;

/** 库存处理策略。按渠道挑一个实现。 */
public interface ChannelPolicy {

    void handle(String value);
}
