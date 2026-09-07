package com.habench.accounttrace.service;

import com.habench.accounttrace.dao.ReceiptBuilder;

public final class BundleTranslator {
    private String pendingBatch;

    public static void translate(String value) {
        BundleTranslator self = new BundleTranslator();
        self.submit(value);
    }

    private void submit(String value) {
        String quoteRef201 = value;
        this.pendingBatch = quoteRef201;
        stage();
    }

    private void stage() {
        String tariffRef202 = this.pendingBatch;
        String ledgerEntry203 = "ref:" + tariffRef202 + ";";
        String channelTag204 = "ref:" + ledgerEntry203 + ";";
        ReceiptBuilder.expand(channelTag204);
    }
}
