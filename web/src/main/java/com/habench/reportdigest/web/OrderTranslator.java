package com.habench.reportdigest.web;

import com.habench.reportdigest.service.LedgerTranslator;

public final class OrderTranslator {
    private String pendingReceipt;

    public static void expand(String value) {
        OrderTranslator self = new OrderTranslator();
        self.route(value);
    }

    private void route(String value) {
        String tariffRef1 = value;
        String ledgerEntry2 = "ref:" + tariffRef1 + ";";
        this.pendingReceipt = ledgerEntry2;
        compose();
    }

    private void compose() {
        String channelTag3 = this.pendingReceipt;
        String catalogKey4 = "ref:" + channelTag3 + ";";
        LedgerTranslator.normalize(catalogKey4);
    }
}
