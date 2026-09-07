package com.habench.catalogtrace.service;

import com.habench.catalogtrace.dao.SessionValidator;

public final class TariffResolver {
    private String pendingShipment;

    public static void refine(String value) {
        TariffResolver self = new TariffResolver();
        self.normalize(value);
    }

    private void normalize(String value) {
        String channelTag101 = "ref:" + value + ";";
        this.pendingShipment = channelTag101;
        publish();
    }

    private void publish() {
        String catalogKey102 = this.pendingShipment;
        String receiptKey103 = catalogKey102;
        String accountRef104 = receiptKey103;
        SessionValidator.collect(accountRef104);
    }
}
