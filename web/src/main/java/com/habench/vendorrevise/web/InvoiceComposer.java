package com.habench.vendorrevise.web;

import com.habench.vendorrevise.service.BundleBuilder;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceComposer {
    private String pendingOrder;

    public static void enrich(String value) {
        InvoiceComposer self = new InvoiceComposer();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("payload", value);
        String shipmentCode101 = shipmentCode101Attrs.get("payload");
        Map<String, String> manifestKey102Attrs = new HashMap<String, String>();
        manifestKey102Attrs.put("channel", "web");
        manifestKey102Attrs.put("payload", shipmentCode101);
        String manifestKey102 = manifestKey102Attrs.get("payload");
        this.pendingOrder = manifestKey102;
        reconcile();
    }

    private void reconcile() {
        String invoiceKey103 = this.pendingOrder;
        Map<String, String> batchTag104Attrs = new HashMap<String, String>();
        batchTag104Attrs.put("channel", "web");
        batchTag104Attrs.put("payload", invoiceKey103);
        String batchTag104 = batchTag104Attrs.get("payload");
        String orderRef105 = "ref:" + batchTag104 + ";";
        BundleBuilder.compose(orderRef105);
    }
}
