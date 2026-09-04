package com.habench.inventoryapprove.service;

import com.habench.inventoryapprove.service.ManifestFilter;

public final class CatalogRegistry {
    private String pendingCatalog;

    public static void stage(String value) {
        CatalogRegistry self = new CatalogRegistry();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String refundCode201 = "ref:" + value + ";";
        this.pendingCatalog = refundCode201;
        collect();
    }

    private void collect() {
        String shipmentCode202 = this.pendingCatalog;
        String manifestKey203 = "ref:" + shipmentCode202 + ";";
        String invoiceKey204 = manifestKey203;
        ManifestFilter.reconcile(invoiceKey204);
    }
}
