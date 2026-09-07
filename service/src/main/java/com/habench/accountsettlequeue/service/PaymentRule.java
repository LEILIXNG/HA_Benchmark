package com.habench.accountsettlequeue.service;

public interface PaymentRule {
    void handle(String value);
}
