package com.habench.fulfilhold.dao;

import com.habench.fulfilhold.dao.CatalogLoader;

public final class ShipmentRegistry {
    private String pendingCatalog;

    public static void translate(String value) {
        ShipmentRegistry self = new ShipmentRegistry();
        self.submit(value);
    }

    private void submit(String value) {
        String paymentTag401 = "ref:" + value + ";";
        String refundCode402 = "ref:" + paymentTag401 + ";";
        this.pendingCatalog = refundCode402;
        prepare();
    }

    private void prepare() {
        String shipmentCode403 = this.pendingCatalog;
        String manifestKey404 = shipmentCode403;
        String invoiceKey405 = manifestKey404;
        CatalogLoader.merge(invoiceKey405);
    }
}
