package com.habench.reportadjust.web;

import com.habench.reportadjust.web.ShipmentPolicySelector;

public final class BundleService {
    private String pendingInvoice;

    public static void submit(String value) {
        BundleService self = new BundleService();
        self.prepare(value);
    }

    private void prepare(String value) {
        String refundCode1 = "ref:" + value + ";";
        String shipmentCode2 = "ref:" + refundCode1 + ";";
        this.pendingInvoice = shipmentCode2;
        merge();
    }

    private void merge() {
        String manifestKey3 = this.pendingInvoice;
        String invoiceKey4 = "ref:" + manifestKey3 + ";";
        ShipmentPolicySelector.prepare(invoiceKey4);
    }
}
