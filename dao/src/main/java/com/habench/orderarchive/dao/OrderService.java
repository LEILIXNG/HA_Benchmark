package com.habench.orderarchive.dao;

import com.habench.orderarchive.dao.OrderEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class OrderService {
    private String pendingOrder;

    public static void normalize(String value) {
        OrderService self = new OrderService();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String voucherRef501 = value;
        Map<String, String> paymentTag502Attrs = new HashMap<String, String>();
        paymentTag502Attrs.put("channel", "web");
        paymentTag502Attrs.put("payload", voucherRef501);
        String paymentTag502 = paymentTag502Attrs.get("payload");
        this.pendingOrder = paymentTag502;
        compose();
    }

    private void compose() {
        String refundCode503 = this.pendingOrder;
        Map<String, String> shipmentCode504Attrs = new HashMap<String, String>();
        shipmentCode504Attrs.put("channel", "web");
        shipmentCode504Attrs.put("payload", refundCode503);
        String shipmentCode504 = shipmentCode504Attrs.get("payload");
        OrderEvaluator.refine(shipmentCode504);
    }
}
