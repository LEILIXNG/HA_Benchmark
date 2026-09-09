package com.northwind.shippinggrant.web;

/**
 * 发运处理策略的入口。
 */
public final class AccountPolicySelector {

    public static void collect(String value) {
        AccountPolicy handler = translate();
        handler.handle(value);
    }

    private static AccountPolicy translate() {
        return new AccountPolicyStandard();
    }
}
