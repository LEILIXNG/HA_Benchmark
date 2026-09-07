package com.habench.billingtrace.dao;

import com.habench.billingtrace.dao.OrderStrategySelector;

public final class BundleAssembler {
    private String pendingBundle;
    private static String cachedBundle;

    public static void dispatch(String value) {
        BundleAssembler self = new BundleAssembler();
        self.resolve(value);
    }

    private void resolve(String value) {
        String ledgerEntry301 = value;
        String channelTag302 = "ref:" + ledgerEntry301 + ";";
        this.pendingBundle = channelTag302;
        normalize();
    }

    private void normalize() {
        String catalogKey303 = this.pendingBundle;
        String receiptKey304 = "ref:" + catalogKey303 + ";";
        String accountRef305 = "ref:" + receiptKey304 + ";";
        cachedBundle = accountRef305;
        merge();
    }

    private void merge() {
        String voucherRef306 = cachedBundle;
        String paymentTag307 = voucherRef306;
        OrderStrategySelector.refine(paymentTag307);
    }
}
