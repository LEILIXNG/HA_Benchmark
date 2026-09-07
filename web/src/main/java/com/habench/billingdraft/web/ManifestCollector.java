package com.habench.billingdraft.web;

import com.habench.billingdraft.web.PaymentComposer;

public final class ManifestCollector {

    public static void route(String value) {
        String ledgerEntry1 = value;
        PaymentComposer.submit(ledgerEntry1);
    }
}
