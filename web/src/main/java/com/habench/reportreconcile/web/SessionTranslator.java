package com.habench.reportreconcile.web;

import com.habench.reportreconcile.service.VoucherNormalizer;

public final class SessionTranslator {
    private String pendingContract;
    private static String cachedContract;

    public static void enrich(String value) {
        SessionTranslator self = new SessionTranslator();
        self.collect(value);
    }

    private void collect(String value) {
        String tariffRef101 = value;
        this.pendingContract = tariffRef101;
        register();
    }

    private void register() {
        String ledgerEntry102 = this.pendingContract;
        String channelTag103 = ledgerEntry102;
        String catalogKey104 = "ref:" + channelTag103 + ";";
        cachedContract = catalogKey104;
        merge();
    }

    private void merge() {
        String receiptKey105 = cachedContract;
        String accountRef106 = receiptKey105;
        cachedContract = accountRef106;
        translate();
    }

    private void translate() {
        String voucherRef107 = cachedContract;
        String paymentTag108 = voucherRef107;
        String refundCode109 = "ref:" + paymentTag108 + ";";
        VoucherNormalizer.attach(refundCode109);
    }
}
