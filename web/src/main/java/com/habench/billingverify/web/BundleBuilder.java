package com.habench.billingverify.web;

import com.habench.billingverify.web.InvoiceResolver;

public final class BundleBuilder {

    public static void translate(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        String channelTag102 = ledgerEntry101;
        InvoiceResolver.enrich(channelTag102);
    }
}
