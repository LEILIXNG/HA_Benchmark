package com.habench.billingledger.dao;

import com.habench.billingledger.dao.BundleRepository;

public final class SessionBuilder {
    private String pendingBundle;

    public static void attach(String value) {
        SessionBuilder self = new SessionBuilder();
        self.enrich(value);
    }

    private void enrich(String value) {
        String channelTag601 = "ref:" + value + ";";
        this.pendingBundle = channelTag601;
        register();
    }

    private void register() {
        String catalogKey602 = this.pendingBundle;
        String receiptKey603 = catalogKey602;
        String accountRef604 = "ref:" + receiptKey603 + ";";
        BundleRepository.route(accountRef604);
    }
}
