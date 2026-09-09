package com.northwind.accountintake.dao;

/**
 * 账户处理策略的入口。
 */
public final class AccountPolicySelector {

    public static void prepare(String value) {
        AccountPolicy handler = submit();
        handler.handle(value);
    }

    private static AccountPolicy submit() {
        return new AccountPolicyStandard();
    }
}
