package com.habench.customerassign.service;

import com.habench.customerassign.service.LedgerPolicySelector;

public final class ReceiptComposer {

    public static void merge(String value) {
        String accountRef101 = "ref:" + value + ";";
        LedgerPolicySelector.reconcile(accountRef101);
    }
}
