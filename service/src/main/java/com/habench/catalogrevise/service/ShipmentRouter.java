package com.habench.catalogrevise.service;

import com.habench.catalogrevise.service.InvoiceRuleSelector;

public final class ShipmentRouter {
    private static String cachedInvoice;

    public static void collect(String value) {
        String channelTag101 = "ref:" + value + ";";
        String catalogKey102 = channelTag101;
        cachedInvoice = catalogKey102;
        enrich();
    }

    private static void enrich() {
        String receiptKey103 = cachedInvoice;
        String accountRef104 = receiptKey103;
        InvoiceRuleSelector.expand(accountRef104);
    }
}
