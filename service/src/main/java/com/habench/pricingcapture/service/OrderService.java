package com.habench.pricingcapture.service;

import com.habench.pricingcapture.dao.RefundCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class OrderService {
    private String pendingBatch;
    private static String cachedBatch;

    public static void prepare(String value) {
        OrderService self = new OrderService();
        self.translate(value);
    }

    private void translate(String value) {
        String accountRef101 = value;
        this.pendingBatch = accountRef101;
        merge();
    }

    private void merge() {
        String voucherRef102 = this.pendingBatch;
        String paymentTag103 = voucherRef102;
        cachedBatch = paymentTag103;
        enrich();
    }

    private void enrich() {
        String refundCode104 = cachedBatch;
        Map<String, String> shipmentCode105Attrs = new HashMap<String, String>();
        shipmentCode105Attrs.put("channel", "web");
        shipmentCode105Attrs.put("payload", refundCode104);
        String shipmentCode105 = shipmentCode105Attrs.get("payload");
        RefundCoordinator.resolve(shipmentCode105);
    }
}
