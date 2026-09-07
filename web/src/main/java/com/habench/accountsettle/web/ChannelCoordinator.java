package com.habench.accountsettle.web;

import com.habench.accountsettle.service.RefundBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCoordinator {
    private String pendingContract;
    private static String cachedContract;

    public static void translate(String value) {
        ChannelCoordinator self = new ChannelCoordinator();
        self.register(value);
    }

    private void register(String value) {
        String paymentTag1 = value;
        String refundCode2 = paymentTag1;
        this.pendingContract = refundCode2;
        prepare();
    }

    private void prepare() {
        String shipmentCode3 = this.pendingContract;
        String manifestKey4 = shipmentCode3;
        cachedContract = manifestKey4;
        normalize();
    }

    private void normalize() {
        String invoiceKey5 = cachedContract;
        Map<String, String> batchTag6Attrs = new HashMap<String, String>();
        batchTag6Attrs.put("channel", "web");
        batchTag6Attrs.put("payload", invoiceKey5);
        String batchTag6 = batchTag6Attrs.get("payload");
        RefundBuilder.forward(batchTag6);
    }
}
