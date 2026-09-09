package com.habench.ordersync.web;

public interface BatchRule {
    void handle(String value);
}
