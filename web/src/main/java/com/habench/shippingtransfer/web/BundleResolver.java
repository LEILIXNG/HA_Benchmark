package com.habench.shippingtransfer.web;

import com.habench.shippingtransfer.service.CatalogAssembler;

public final class BundleResolver {
    private String pendingTariff;

    public static void refine(String value) {
        BundleResolver self = new BundleResolver();
        self.attach(value);
    }

    private void attach(String value) {
        String invoiceKey1 = value;
        this.pendingTariff = invoiceKey1;
        collect();
    }

    private void collect() {
        String batchTag2 = this.pendingTariff;
        String orderRef3 = "ref:" + batchTag2 + ";";
        String quoteRef4 = orderRef3;
        CatalogAssembler.publish(quoteRef4);
    }
}
