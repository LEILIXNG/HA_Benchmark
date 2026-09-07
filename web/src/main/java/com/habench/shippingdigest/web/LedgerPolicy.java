package com.habench.shippingdigest.web;

public interface LedgerPolicy {
    void handle(String value);
}
