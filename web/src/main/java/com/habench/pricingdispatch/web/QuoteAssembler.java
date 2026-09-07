package com.habench.pricingdispatch.web;

import com.habench.pricingdispatch.web.BundleComposer;

public final class QuoteAssembler {
    private String pendingAccount;
    private static String cachedAccount;

    public static void forward(String value) {
        QuoteAssembler self = new QuoteAssembler();
        self.attach(value);
    }

    private void attach(String value) {
        String manifestKey1 = "ref:" + value + ";";
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        this.pendingAccount = invoiceKey2;
        normalize();
    }

    private void normalize() {
        String batchTag3 = this.pendingAccount;
        String orderRef4 = "ref:" + batchTag3 + ";";
        String quoteRef5 = "ref:" + orderRef4 + ";";
        cachedAccount = quoteRef5;
        submit();
    }

    private void submit() {
        String tariffRef6 = cachedAccount;
        String ledgerEntry7 = tariffRef6;
        String channelTag8 = "ref:" + ledgerEntry7 + ";";
        BundleComposer.resolve(channelTag8);
    }
}
