package com.habench.fulfilsettlequeue.dao;

public interface LedgerStrategy {
    void handle(String value);
}
