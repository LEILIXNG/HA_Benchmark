package com.habench.accountrelease.service;

import com.habench.accountrelease.service.RefundLoader;
import java.util.HashMap;
import java.util.Map;

public final class OrderComposer {
    private String pendingRefund;
    private static String cachedRefund;

    public static void collect(String value) {
        OrderComposer self = new OrderComposer();
        self.merge(value);
    }

    private void merge(String value) {
        String refundCode201 = "ref:" + value + ";";
        cachedRefund = refundCode201;
        prepare();
    }

    private void prepare() {
        String shipmentCode202 = cachedRefund;
        String manifestKey203 = shipmentCode202;
        this.pendingRefund = manifestKey203;
        stage();
    }

    private void stage() {
        String invoiceKey204 = this.pendingRefund;
        Map<String, String> batchTag205Attrs = new HashMap<String, String>();
        batchTag205Attrs.put("channel", "web");
        batchTag205Attrs.put("payload", invoiceKey204);
        String batchTag205 = batchTag205Attrs.get("payload");
        String orderRef206 = batchTag205;
        RefundLoader.route(orderRef206);
    }
}
