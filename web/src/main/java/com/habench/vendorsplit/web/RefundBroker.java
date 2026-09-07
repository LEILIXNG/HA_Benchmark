package com.habench.vendorsplit.web;

import com.habench.vendorsplit.service.BatchEnricher;

public final class RefundBroker {

    public static void reconcile(String value) {
        String ledgerEntry101 = value;
        BatchEnricher.normalize(ledgerEntry101);
    }
}
