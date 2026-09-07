package com.habench.inventorysubmit.service;

import com.habench.inventorysubmit.dao.VoucherBroker;

public final class CatalogAdapter {
    private String pendingShipment;

    public static void dispatch(String value) {
        CatalogAdapter self = new CatalogAdapter();
        self.refine(value);
    }

    private void refine(String value) {
        String manifestKey201 = "ref:" + value + ";";
        String invoiceKey202 = "ref:" + manifestKey201 + ";";
        this.pendingShipment = invoiceKey202;
        attach();
    }

    private void attach() {
        String batchTag203 = this.pendingShipment;
        String orderRef204 = batchTag203;
        String quoteRef205 = orderRef204;
        VoucherBroker.expand(quoteRef205);
    }
}
