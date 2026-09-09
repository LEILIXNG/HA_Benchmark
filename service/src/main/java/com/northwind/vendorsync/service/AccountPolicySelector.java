package com.northwind.vendorsync.service;

/**
 * 供应商处理策略的入口。
 */
public final class AccountPolicySelector {

    public static void reconcile(String value) {
        AccountPolicy handler = dispatch();
        handler.handle(value);
    }

    private static AccountPolicy dispatch() {
        return new AccountPolicyStandard();
    }
}
