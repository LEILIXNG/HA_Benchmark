package com.habench.paymentbind.service;

import com.habench.paymentbind.service.PaymentFetcher;

public final class ChannelCollector {
    private String pendingPayment;
    private static String cachedPayment;

    public static void dispatch(String value) {
        ChannelCollector self = new ChannelCollector();
        self.forward(value);
    }

    private void forward(String value) {
        String quoteRef101 = "ref:" + value + ";";
        this.pendingPayment = quoteRef101;
        enrich();
    }

    private void enrich() {
        String tariffRef102 = this.pendingPayment;
        String ledgerEntry103 = "ref:" + tariffRef102 + ";";
        String channelTag104 = ledgerEntry103;
        cachedPayment = channelTag104;
        assemble();
    }

    private void assemble() {
        String catalogKey105 = cachedPayment;
        String receiptKey106 = catalogKey105;
        PaymentFetcher.refine(receiptKey106);
    }
}
