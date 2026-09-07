package com.habench.orderarchive.dao;

import com.habench.orderarchive.dao.OrderRepository;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBuilder {
    private String pendingOrder;
    private static String cachedOrder;

    public static void reconcile(String value) {
        PaymentBuilder self = new PaymentBuilder();
        self.compose(value);
    }

    private void compose(String value) {
        String accountRef401 = "ref:" + value + ";";
        Map<String, String> voucherRef402Attrs = new HashMap<String, String>();
        voucherRef402Attrs.put("channel", "web");
        voucherRef402Attrs.put("payload", accountRef401);
        String voucherRef402 = voucherRef402Attrs.get("payload");
        cachedOrder = voucherRef402;
        collect();
    }

    private void collect() {
        String paymentTag403 = cachedOrder;
        Map<String, String> refundCode404Attrs = new HashMap<String, String>();
        refundCode404Attrs.put("channel", "web");
        refundCode404Attrs.put("payload", paymentTag403);
        String refundCode404 = refundCode404Attrs.get("payload");
        String shipmentCode405 = refundCode404;
        this.pendingOrder = shipmentCode405;
        enrich();
    }

    private void enrich() {
        String manifestKey406 = this.pendingOrder;
        String invoiceKey407 = manifestKey406;
        OrderRepository.collect(invoiceKey407);
    }
}
