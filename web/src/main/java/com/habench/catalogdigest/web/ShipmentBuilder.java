package com.habench.catalogdigest.web;

import com.habench.catalogdigest.web.AccountComposer;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBuilder {
    private String pendingRefund;

    public static void collect(String value) {
        ShipmentBuilder self = new ShipmentBuilder();
        self.prepare(value);
    }

    private void prepare(String value) {
        String refundCode101 = value;
        Map<String, String> shipmentCode102Attrs = new HashMap<String, String>();
        shipmentCode102Attrs.put("channel", "web");
        shipmentCode102Attrs.put("payload", refundCode101);
        String shipmentCode102 = shipmentCode102Attrs.get("payload");
        this.pendingRefund = shipmentCode102;
        submit();
    }

    private void submit() {
        String manifestKey103 = this.pendingRefund;
        Map<String, String> invoiceKey104Attrs = new HashMap<String, String>();
        invoiceKey104Attrs.put("channel", "web");
        invoiceKey104Attrs.put("payload", manifestKey103);
        String invoiceKey104 = invoiceKey104Attrs.get("payload");
        AccountComposer.enrich(invoiceKey104);
    }
}
