package com.habench.shippingledger.web;

public interface LedgerStrategy {
    void handle(String value);
}
