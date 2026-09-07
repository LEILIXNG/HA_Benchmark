package com.habench.customertrace.service;

import com.habench.customertrace.service.BundleNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class OrderCoordinator {
    private String pendingRefund;
    private static String cachedRefund;

    public static void reconcile(String value) {
        OrderCoordinator self = new OrderCoordinator();
        self.enrich(value);
    }

    private void enrich(String value) {
        String accountRef101 = value;
        String voucherRef102 = accountRef101;
        this.pendingRefund = voucherRef102;
        collect();
    }

    private void collect() {
        String paymentTag103 = this.pendingRefund;
        Map<String, String> refundCode104Attrs = new HashMap<String, String>();
        refundCode104Attrs.put("channel", "web");
        refundCode104Attrs.put("payload", paymentTag103);
        String refundCode104 = refundCode104Attrs.get("payload");
        cachedRefund = refundCode104;
        refine();
    }

    private void refine() {
        String shipmentCode105 = cachedRefund;
        String manifestKey106 = "ref:" + shipmentCode105 + ";";
        BundleNormalizer.publish(manifestKey106);
    }
}
