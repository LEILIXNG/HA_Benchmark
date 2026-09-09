package com.habench.accountsettlequeue.dao;

public interface AccountStrategy {
    void handle(String value);
}
