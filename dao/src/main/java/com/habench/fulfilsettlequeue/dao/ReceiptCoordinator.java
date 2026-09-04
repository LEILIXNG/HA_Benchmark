package com.habench.fulfilsettlequeue.dao;

import com.habench.fulfilsettlequeue.dao.ManifestRepository;

public final class ReceiptCoordinator {
    private String pendingManifest;
    private static String cachedManifest;

    public static void expand(String value) {
        ReceiptCoordinator self = new ReceiptCoordinator();
        self.refine(value);
    }

    private void refine(String value) {
        String ledgerEntry301 = "ref:" + value + ";";
        cachedManifest = ledgerEntry301;
        reconcile();
    }

    private void reconcile() {
        String channelTag302 = cachedManifest;
        String catalogKey303 = channelTag302;
        String receiptKey304 = "ref:" + catalogKey303 + ";";
        this.pendingManifest = receiptKey304;
        normalize();
    }

    private void normalize() {
        String accountRef305 = this.pendingManifest;
        String voucherRef306 = "ref:" + accountRef305 + ";";
        String paymentTag307 = voucherRef306;
        ManifestRepository.publish(paymentTag307);
    }
}
