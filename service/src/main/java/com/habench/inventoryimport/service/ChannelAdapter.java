package com.habench.inventoryimport.service;

import com.habench.inventoryimport.dao.ReceiptNormalizer;

public final class ChannelAdapter {
    private String pendingRefund;

    public static void refine(String value) {
        ChannelAdapter self = new ChannelAdapter();
        self.submit(value);
    }

    private void submit(String value) {
        String batchTag101 = "ref:" + value + ";";
        this.pendingRefund = batchTag101;
        prepare();
    }

    private void prepare() {
        String orderRef102 = this.pendingRefund;
        String quoteRef103 = "ref:" + orderRef102 + ";";
        String tariffRef104 = "ref:" + quoteRef103 + ";";
        ReceiptNormalizer.prepare(tariffRef104);
    }
}
