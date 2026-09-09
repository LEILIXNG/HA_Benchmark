package com.habench.customerbind.service;

import com.habench.customerbind.service.LedgerPolicySelector;

public final class ReceiptComposer {

    public static void merge(String value) {
        String accountRef101 = "ref:" + value + ";";
        LedgerPolicySelector.reconcile(accountRef101);
    }
}
