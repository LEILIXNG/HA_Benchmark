package com.habench.billingadjust.web;

import com.habench.billingadjust.web.InvoicePlanSelector;

public final class QuoteAssembler {

    public static void publish(String value) {
        String invoiceKey1 = value;
        String batchTag2 = invoiceKey1;
        InvoicePlanSelector.attach(batchTag2);
    }
}
