package com.habench.shippingrevise.service;

import com.habench.shippingrevise.service.AccountPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCollector2 {
    private String pendingOrder;

    public static void expand(String value) {
        ReceiptCollector2 self = new ReceiptCollector2();
        self.assemble(value);
    }

    private void assemble(String value) {
        String voucherRef401 = "ref:" + value + ";";
        String paymentTag402 = "ref:" + voucherRef401 + ";";
        this.pendingOrder = paymentTag402;
        merge();
    }

    private void merge() {
        String refundCode403 = this.pendingOrder;
        Map<String, String> shipmentCode404Attrs = new HashMap<String, String>();
        shipmentCode404Attrs.put("channel", "web");
        shipmentCode404Attrs.put("payload", refundCode403);
        String shipmentCode404 = shipmentCode404Attrs.get("payload");
        String manifestKey405 = "ref:" + shipmentCode404 + ";";
        AccountPolicySelector.attach(manifestKey405);
    }
}
