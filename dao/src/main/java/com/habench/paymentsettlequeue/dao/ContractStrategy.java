package com.habench.paymentsettlequeue.dao;

public interface ContractStrategy {
    void handle(String value);
}
