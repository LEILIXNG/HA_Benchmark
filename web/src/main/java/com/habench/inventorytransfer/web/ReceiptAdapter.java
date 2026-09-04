package com.habench.inventorytransfer.web;

import com.habench.inventorytransfer.web.ManifestRepository;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptAdapter {
    private String pendingManifest;
    private static String cachedManifest;

    public static void refine(String value) {
        ReceiptAdapter self = new ReceiptAdapter();
        self.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        this.pendingManifest = voucherRef1;
        publish();
    }

    private void publish() {
        String paymentTag2 = this.pendingManifest;
        Map<String, String> refundCode3Attrs = new HashMap<String, String>();
        refundCode3Attrs.put("channel", "web");
        refundCode3Attrs.put("payload", paymentTag2);
        String refundCode3 = refundCode3Attrs.get("payload");
        cachedManifest = refundCode3;
        collect();
    }

    private void collect() {
        String shipmentCode4 = cachedManifest;
        Map<String, String> manifestKey5Attrs = new HashMap<String, String>();
        manifestKey5Attrs.put("channel", "web");
        manifestKey5Attrs.put("payload", shipmentCode4);
        String manifestKey5 = manifestKey5Attrs.get("payload");
        String invoiceKey6 = "ref:" + manifestKey5 + ";";
        ManifestRepository.compose(invoiceKey6);
    }
}
