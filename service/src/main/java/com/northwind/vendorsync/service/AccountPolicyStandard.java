package com.northwind.vendorsync.service;

/**
 * 供应商的默认处理策略。
 */
public final class AccountPolicyStandard implements AccountPolicy {

    @Override
    public void handle(String value) {
        SessionService.attach(value);
    }
}
