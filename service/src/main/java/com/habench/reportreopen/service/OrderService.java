package com.habench.reportreopen.service;

import com.habench.reportreopen.dao.RefundComposer;
import java.util.HashMap;
import java.util.Map;

public final class OrderService {
    private String pendingVoucher;

    public static void prepare(String value) {
        OrderService self = new OrderService();
        self.register(value);
    }

    private void register(String value) {
        String paymentTag101 = value;
        this.pendingVoucher = paymentTag101;
        dispatch();
    }

    private void dispatch() {
        String refundCode102 = this.pendingVoucher;
        Map<String, String> shipmentCode103Attrs = new HashMap<String, String>();
        shipmentCode103Attrs.put("channel", "web");
        shipmentCode103Attrs.put("payload", refundCode102);
        String shipmentCode103 = shipmentCode103Attrs.get("payload");
        String manifestKey104 = shipmentCode103;
        RefundComposer.expand(manifestKey104);
    }
}
