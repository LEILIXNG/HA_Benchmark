package com.habench.billingsync.service;

import com.habench.billingsync.service.BundleEnricher;

public final class LedgerBroker {

    public static void enrich(String value) {
        String catalogKey201 = value;
        String receiptKey202 = "ref:" + catalogKey201 + ";";
        BundleEnricher.assemble(receiptKey202);
    }
}
