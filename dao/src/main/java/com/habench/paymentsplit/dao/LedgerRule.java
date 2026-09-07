package com.habench.paymentsplit.dao;

public interface LedgerRule {
    void handle(String value);
}
