package com.habench.customerrollup.service;

import com.habench.customerrollup.service.ManifestStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBuilder {
    private String pendingChannel;

    public static void enrich(String value) {
        InvoiceBuilder self = new InvoiceBuilder();
        self.translate(value);
    }

    private void translate(String value) {
        String refundCode301 = "ref:" + value + ";";
        Map<String, String> shipmentCode302Attrs = new HashMap<String, String>();
        shipmentCode302Attrs.put("channel", "web");
        shipmentCode302Attrs.put("payload", refundCode301);
        String shipmentCode302 = shipmentCode302Attrs.get("payload");
        this.pendingChannel = shipmentCode302;
        prepare();
    }

    private void prepare() {
        String manifestKey303 = this.pendingChannel;
        Map<String, String> invoiceKey304Attrs = new HashMap<String, String>();
        invoiceKey304Attrs.put("channel", "web");
        invoiceKey304Attrs.put("payload", manifestKey303);
        String invoiceKey304 = invoiceKey304Attrs.get("payload");
        String batchTag305 = invoiceKey304;
        ManifestStrategySelector.enrich(batchTag305);
    }
}
