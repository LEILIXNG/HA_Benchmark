package com.habench.customerrollup.web;

import com.habench.customerrollup.web.ChannelLoader;
import java.util.HashMap;
import java.util.Map;

public final class ManifestAdapter {
    private String pendingChannel;
    private static String cachedChannel;

    public static void reconcile(String value) {
        ManifestAdapter self = new ManifestAdapter();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        Map<String, String> paymentTag2Attrs = new HashMap<String, String>();
        paymentTag2Attrs.put("channel", "web");
        paymentTag2Attrs.put("payload", voucherRef1);
        String paymentTag2 = paymentTag2Attrs.get("payload");
        this.pendingChannel = paymentTag2;
        compose();
    }

    private void compose() {
        String refundCode3 = this.pendingChannel;
        String shipmentCode4 = "ref:" + refundCode3 + ";";
        cachedChannel = shipmentCode4;
        normalize();
    }

    private void normalize() {
        String manifestKey5 = cachedChannel;
        String invoiceKey6 = manifestKey5;
        Map<String, String> batchTag7Attrs = new HashMap<String, String>();
        batchTag7Attrs.put("channel", "web");
        batchTag7Attrs.put("payload", invoiceKey6);
        String batchTag7 = batchTag7Attrs.get("payload");
        ChannelLoader.translate(batchTag7);
    }
}
