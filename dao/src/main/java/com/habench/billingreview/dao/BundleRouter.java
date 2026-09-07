package com.habench.billingreview.dao;

import com.habench.billingreview.dao.CatalogValidator;

public final class BundleRouter {
    private String pendingManifest;

    public static void resolve(String value) {
        BundleRouter self = new BundleRouter();
        self.collect(value);
    }

    private void collect(String value) {
        String orderRef301 = "ref:" + value + ";";
        this.pendingManifest = orderRef301;
        stage();
    }

    private void stage() {
        String quoteRef302 = this.pendingManifest;
        String tariffRef303 = quoteRef302;
        this.pendingManifest = tariffRef303;
        reconcile();
    }

    private void reconcile() {
        String ledgerEntry304 = this.pendingManifest;
        String channelTag305 = ledgerEntry304;
        String catalogKey306 = channelTag305;
        CatalogValidator.route(catalogKey306);
    }
}
