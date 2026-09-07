package com.habench.vendorverify.service;

import com.habench.vendorverify.dao.BundleAssembler;

public final class PaymentBroker {
    private String pendingManifest;
    private static String cachedManifest;

    public static void compose(String value) {
        PaymentBroker self = new PaymentBroker();
        self.resolve(value);
    }

    private void resolve(String value) {
        String tariffRef501 = "ref:" + value + ";";
        String ledgerEntry502 = "ref:" + tariffRef501 + ";";
        cachedManifest = ledgerEntry502;
        merge();
    }

    private void merge() {
        String channelTag503 = cachedManifest;
        String catalogKey504 = "ref:" + channelTag503 + ";";
        String receiptKey505 = "ref:" + catalogKey504 + ";";
        this.pendingManifest = receiptKey505;
        register();
    }

    private void register() {
        String accountRef506 = this.pendingManifest;
        String voucherRef507 = "ref:" + accountRef506 + ";";
        BundleAssembler.submit(voucherRef507);
    }
}
