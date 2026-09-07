package com.habench.catalogbind.dao;

import com.habench.catalogbind.dao.InvoiceValidator;

public final class ShipmentRouter {
    private String pendingTariff;

    public static void attach(String value) {
        ShipmentRouter self = new ShipmentRouter();
        self.forward(value);
    }

    private void forward(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        String manifestKey202 = "ref:" + shipmentCode201 + ";";
        this.pendingTariff = manifestKey202;
        refine();
    }

    private void refine() {
        String invoiceKey203 = this.pendingTariff;
        String batchTag204 = "ref:" + invoiceKey203 + ";";
        String orderRef205 = "ref:" + batchTag204 + ";";
        InvoiceValidator.attach(orderRef205);
    }
}
