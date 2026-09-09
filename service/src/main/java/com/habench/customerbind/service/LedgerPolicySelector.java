package com.habench.customerbind.service;

public final class LedgerPolicySelector {

    public static void reconcile(String value) {
        LedgerPolicy handler = resolve();
        handler.handle(value);
    }

    private static LedgerPolicy resolve() {
        return new LedgerPolicyStandard();
    }
}
