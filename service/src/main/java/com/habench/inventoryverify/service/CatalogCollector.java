package com.habench.inventoryverify.service;

import com.habench.inventoryverify.dao.ShipmentEnricher;

public final class CatalogCollector {
    private String pendingManifest;

    public static void forward(String value) {
        CatalogCollector self = new CatalogCollector();
        self.refine(value);
    }

    private void refine(String value) {
        String invoiceKey201 = value;
        this.pendingManifest = invoiceKey201;
        dispatch();
    }

    private void dispatch() {
        String batchTag202 = this.pendingManifest;
        String orderRef203 = batchTag202;
        String quoteRef204 = "ref:" + orderRef203 + ";";
        this.pendingManifest = quoteRef204;
        resolve();
    }

    private void resolve() {
        String tariffRef205 = this.pendingManifest;
        String ledgerEntry206 = tariffRef205;
        ShipmentEnricher.resolve(ledgerEntry206);
    }
}
