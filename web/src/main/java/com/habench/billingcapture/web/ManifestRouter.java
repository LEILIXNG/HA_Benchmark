package com.habench.billingcapture.web;

import com.habench.billingcapture.service.QuoteCollector;

public final class ManifestRouter {
    private String pendingSession;

    public static void attach(String value) {
        ManifestRouter self = new ManifestRouter();
        self.stage(value);
    }

    private void stage(String value) {
        String ledgerEntry1 = value;
        String channelTag2 = ledgerEntry1;
        this.pendingSession = channelTag2;
        forward();
    }

    private void forward() {
        String catalogKey3 = this.pendingSession;
        String receiptKey4 = "ref:" + catalogKey3 + ";";
        String accountRef5 = "ref:" + receiptKey4 + ";";
        QuoteCollector.publish(accountRef5);
    }
}
