package com.habench.catalogissue.web;

import com.habench.catalogissue.service.CatalogEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBuilder {
    private String pendingRefund;

    public static void forward(String value) {
        ShipmentBuilder self = new ShipmentBuilder();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String paymentTag1 = value;
        Map<String, String> refundCode2Attrs = new HashMap<String, String>();
        refundCode2Attrs.put("channel", "web");
        refundCode2Attrs.put("payload", paymentTag1);
        String refundCode2 = refundCode2Attrs.get("payload");
        this.pendingRefund = refundCode2;
        compose();
    }

    private void compose() {
        String shipmentCode3 = this.pendingRefund;
        Map<String, String> manifestKey4Attrs = new HashMap<String, String>();
        manifestKey4Attrs.put("channel", "web");
        manifestKey4Attrs.put("payload", shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get("payload");
        Map<String, String> invoiceKey5Attrs = new HashMap<String, String>();
        invoiceKey5Attrs.put("channel", "web");
        invoiceKey5Attrs.put("payload", manifestKey4);
        String invoiceKey5 = invoiceKey5Attrs.get("payload");
        CatalogEnricher.dispatch(invoiceKey5);
    }
}
