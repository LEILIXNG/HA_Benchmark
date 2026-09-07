package com.habench.billingdispatch.dao;

import com.habench.billingdispatch.dao.ChannelLoader;

public final class ReceiptTranslator {
    private String pendingChannel;

    public static void resolve(String value) {
        ReceiptTranslator self = new ReceiptTranslator();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String batchTag401 = value;
        this.pendingChannel = batchTag401;
        publish();
    }

    private void publish() {
        String orderRef402 = this.pendingChannel;
        String quoteRef403 = "ref:" + orderRef402 + ";";
        String tariffRef404 = quoteRef403;
        ChannelLoader.normalize(tariffRef404);
    }
}
