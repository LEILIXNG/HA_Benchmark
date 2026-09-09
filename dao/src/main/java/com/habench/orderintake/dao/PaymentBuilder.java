package com.habench.orderintake.dao;

import com.habench.orderintake.dao.OrderRepository;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBuilder {
    private String pendingOrder;

    public static void enrich(String value) {
        PaymentBuilder self = new PaymentBuilder();
        self.compose(value);
    }

    private void compose(String value) {
        String accountRef401 = value;
        Map<String, String> voucherRef402Attrs = new HashMap<String, String>();
        voucherRef402Attrs.put("channel", "web");
        voucherRef402Attrs.put("payload", accountRef401);
        String voucherRef402 = voucherRef402Attrs.get("payload");
        this.pendingOrder = voucherRef402;
        collect();
    }

    private void collect() {
        String paymentTag403 = this.pendingOrder;
        Map<String, String> refundCode404Attrs = new HashMap<String, String>();
        refundCode404Attrs.put("channel", "web");
        refundCode404Attrs.put("payload", paymentTag403);
        String refundCode404 = refundCode404Attrs.get("payload");
        String shipmentCode405 = refundCode404;
        OrderRepository.collect(shipmentCode405);
    }
}
