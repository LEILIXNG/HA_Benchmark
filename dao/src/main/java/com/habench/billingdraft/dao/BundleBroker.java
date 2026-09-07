package com.habench.billingdraft.dao;

import com.habench.billingdraft.dao.ManifestPolicySelector;

public final class BundleBroker {
    private static String cachedChannel;

    public static void dispatch(String value) {
        String invoiceKey401 = value;
        cachedChannel = invoiceKey401;
        prepare();
    }

    private static void prepare() {
        String batchTag402 = cachedChannel;
        String orderRef403 = "ref:" + batchTag402 + ";";
        String quoteRef404 = orderRef403;
        ManifestPolicySelector.stage(quoteRef404);
    }
}
