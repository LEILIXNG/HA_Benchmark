package com.habench.shippingrenewal.web;

import com.habench.shippingrenewal.web.TariffNormalizer;

public final class InvoiceBroker {

    public static void reconcile(String value) {
        String invoiceKey1 = value;
        String batchTag2 = invoiceKey1;
        TariffNormalizer.normalize(batchTag2);
    }
}
