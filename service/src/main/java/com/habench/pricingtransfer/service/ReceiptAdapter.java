package com.habench.pricingtransfer.service;

import com.habench.pricingtransfer.service.ManifestPolicy;

public final class ReceiptAdapter {
    private String pendingSession;

    public static void register(String value) {
        ReceiptAdapter self = new ReceiptAdapter();
        self.attach(value);
    }

    private void attach(String value) {
        String channelTag301 = value;
        this.pendingSession = channelTag301;
        enrich();
    }

    private void enrich() {
        String catalogKey302 = this.pendingSession;
        String receiptKey303 = catalogKey302;
        ManifestPolicy.dispatch(receiptKey303);
    }
}
