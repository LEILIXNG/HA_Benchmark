package com.habench.reportclose.service;

import com.habench.reportclose.service.RefundGateway;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentResolver {
    private String pendingRefund;

    public static void forward(String value) {
        ShipmentResolver self = new ShipmentResolver();
        self.expand(value);
    }

    private void expand(String value) {
        String refundCode101 = value;
        String shipmentCode102 = refundCode101;
        this.pendingRefund = shipmentCode102;
        submit();
    }

    private void submit() {
        String manifestKey103 = this.pendingRefund;
        Map<String, String> invoiceKey104Attrs = new HashMap<String, String>();
        invoiceKey104Attrs.put("channel", "web");
        invoiceKey104Attrs.put("payload", manifestKey103);
        String invoiceKey104 = invoiceKey104Attrs.get("payload");
        this.pendingRefund = invoiceKey104;
        stage();
    }

    private void stage() {
        String batchTag105 = this.pendingRefund;
        String orderRef106 = batchTag105;
        String quoteRef107 = "ref:" + orderRef106 + ";";
        RefundGateway.forward(quoteRef107);
    }
}
