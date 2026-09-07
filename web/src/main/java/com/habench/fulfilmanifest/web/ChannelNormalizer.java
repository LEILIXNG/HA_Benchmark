package com.habench.fulfilmanifest.web;

import com.habench.fulfilmanifest.service.ChannelRouter;
import java.util.HashMap;
import java.util.Map;

public final class ChannelNormalizer {
    private String pendingChannel;
    private static String cachedChannel;

    public static void normalize(String value) {
        ChannelNormalizer self = new ChannelNormalizer();
        self.attach(value);
    }

    private void attach(String value) {
        String voucherRef1 = value;
        String paymentTag2 = "ref:" + voucherRef1 + ";";
        this.pendingChannel = paymentTag2;
        stage();
    }

    private void stage() {
        String refundCode3 = this.pendingChannel;
        Map<String, String> shipmentCode4Attrs = new HashMap<String, String>();
        shipmentCode4Attrs.put("channel", "web");
        shipmentCode4Attrs.put("payload", refundCode3);
        String shipmentCode4 = shipmentCode4Attrs.get("payload");
        cachedChannel = shipmentCode4;
        route();
    }

    private void route() {
        String manifestKey5 = cachedChannel;
        Map<String, String> invoiceKey6Attrs = new HashMap<String, String>();
        invoiceKey6Attrs.put("channel", "web");
        invoiceKey6Attrs.put("payload", manifestKey5);
        String invoiceKey6 = invoiceKey6Attrs.get("payload");
        Map<String, String> batchTag7Attrs = new HashMap<String, String>();
        batchTag7Attrs.put("channel", "web");
        batchTag7Attrs.put("payload", invoiceKey6);
        String batchTag7 = batchTag7Attrs.get("payload");
        ChannelRouter.register(batchTag7);
    }
}
