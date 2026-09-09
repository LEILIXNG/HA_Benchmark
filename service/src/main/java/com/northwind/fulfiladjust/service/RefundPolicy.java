package com.northwind.fulfiladjust.service;

/** 履约处理策略。按渠道挑一个实现。 */
public interface RefundPolicy {

    void handle(String value);
}
