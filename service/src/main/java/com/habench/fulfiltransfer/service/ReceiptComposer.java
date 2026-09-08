package com.habench.fulfiltransfer.service;

import com.habench.fulfiltransfer.service.TariffResolver;

public final class ReceiptComposer {
    private String pendingTariff;
    private static String cachedTariff;

    public static void stage(String value) {
        ReceiptComposer self = new ReceiptComposer();
        self.prepare(value);
    }

    private void prepare(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        this.pendingTariff = ledgerEntry201;
        attach();
    }

    private void attach() {
        String channelTag202 = this.pendingTariff;
        String catalogKey203 = "ref:" + channelTag202 + ";";
        cachedTariff = catalogKey203;
        publish();
    }

    private void publish() {
        String receiptKey204 = cachedTariff;
        String accountRef205 = "ref:" + receiptKey204 + ";";
        String voucherRef206 = "ref:" + accountRef205 + ";";
        TariffResolver.reconcile(voucherRef206);
    }
}
