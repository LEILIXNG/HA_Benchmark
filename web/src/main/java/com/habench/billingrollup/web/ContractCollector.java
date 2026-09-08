package com.habench.billingrollup.web;

import com.habench.billingrollup.web.ReceiptRegistry;

public final class ContractCollector {

    public static void compose(String value) {
        String tariffRef1 = "ref:" + value + ";";
        String ledgerEntry2 = tariffRef1;
        ReceiptRegistry.resolve(ledgerEntry2);
    }
}
