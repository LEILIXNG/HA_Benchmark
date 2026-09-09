package com.habench.customerledger.web;

public interface BatchPolicy {
    void handle(String value);
}
