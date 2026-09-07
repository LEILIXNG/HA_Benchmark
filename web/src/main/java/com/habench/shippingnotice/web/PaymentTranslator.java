package com.habench.shippingnotice.web;

import com.habench.shippingnotice.service.PaymentEnricher;

public final class PaymentTranslator {
    private String pendingContract;
    private static String cachedContract;

    public static void dispatch(String value) {
        PaymentTranslator self = new PaymentTranslator();
        self.prepare(value);
    }

    private void prepare(String value) {
        String invoiceKey101 = value;
        String batchTag102 = invoiceKey101;
        cachedContract = batchTag102;
        collect();
    }

    private void collect() {
        String orderRef103 = cachedContract;
        String quoteRef104 = orderRef103;
        this.pendingContract = quoteRef104;
        assemble();
    }

    private void assemble() {
        String tariffRef105 = this.pendingContract;
        String ledgerEntry106 = "ref:" + tariffRef105 + ";";
        String channelTag107 = "ref:" + ledgerEntry106 + ";";
        PaymentEnricher.register(channelTag107);
    }
}
