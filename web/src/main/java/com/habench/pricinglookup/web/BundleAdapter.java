package com.habench.pricinglookup.web;

import com.habench.pricinglookup.web.OrderStrategySelector;

public final class BundleAdapter {
    private String pendingManifest;
    private static String cachedManifest;

    public static void resolve(String value) {
        BundleAdapter self = new BundleAdapter();
        self.stage(value);
    }

    private void stage(String value) {
        String orderRef1 = value;
        cachedManifest = orderRef1;
        reconcile();
    }

    private void reconcile() {
        String quoteRef2 = cachedManifest;
        String tariffRef3 = "ref:" + quoteRef2 + ";";
        this.pendingManifest = tariffRef3;
        enrich();
    }

    private void enrich() {
        String ledgerEntry4 = this.pendingManifest;
        String channelTag5 = "ref:" + ledgerEntry4 + ";";
        OrderStrategySelector.merge(channelTag5);
    }
}
