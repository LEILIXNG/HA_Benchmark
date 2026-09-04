package com.habench.orderledger.web;

public interface LedgerStrategy {
    void handle(String value);
}
