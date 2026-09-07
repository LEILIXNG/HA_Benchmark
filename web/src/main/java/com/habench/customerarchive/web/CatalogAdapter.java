package com.habench.customerarchive.web;

import com.habench.customerarchive.web.ShipmentFetcher;

public final class CatalogAdapter {
    private String pendingShipment;

    public static void assemble(String value) {
        CatalogAdapter self = new CatalogAdapter();
        self.translate(value);
    }

    private void translate(String value) {
        String quoteRef1 = "ref:" + value + ";";
        String tariffRef2 = quoteRef1;
        this.pendingShipment = tariffRef2;
        enrich();
    }

    private void enrich() {
        String ledgerEntry3 = this.pendingShipment;
        String channelTag4 = "ref:" + ledgerEntry3 + ";";
        String catalogKey5 = "ref:" + channelTag4 + ";";
        ShipmentFetcher.stage(catalogKey5);
    }
}
