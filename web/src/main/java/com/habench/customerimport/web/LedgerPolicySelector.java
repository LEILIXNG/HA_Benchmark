package com.habench.customerimport.web;

public final class LedgerPolicySelector {

    public static void stage(String value) {
        LedgerPolicy handler = register();
        handler.handle(value);
    }

    private static LedgerPolicy register() {
        return new LedgerPolicyStandard();
    }
}
