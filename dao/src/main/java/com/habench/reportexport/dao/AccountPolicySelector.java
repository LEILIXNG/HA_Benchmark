package com.habench.reportexport.dao;

public final class AccountPolicySelector {

    public static void dispatch(String value) {
        AccountPolicy handler = publish();
        handler.handle(value);
    }

    private static AccountPolicy publish() {
        return new AccountPolicyStandard();
    }
}
