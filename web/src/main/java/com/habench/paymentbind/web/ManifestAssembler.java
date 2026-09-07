package com.habench.paymentbind.web;

import com.habench.paymentbind.service.VoucherService;
import java.util.HashMap;
import java.util.Map;

public final class ManifestAssembler {
    private String pendingManifest;

    public static void dispatch(String value) {
        ManifestAssembler self = new ManifestAssembler();
        self.refine(value);
    }

    private void refine(String value) {
        String voucherRef1 = "ref:" + value + ";";
        this.pendingManifest = voucherRef1;
        collect();
    }

    private void collect() {
        String paymentTag2 = this.pendingManifest;
        Map<String, String> refundCode3Attrs = new HashMap<String, String>();
        refundCode3Attrs.put("channel", "web");
        refundCode3Attrs.put("payload", paymentTag2);
        String refundCode3 = refundCode3Attrs.get("payload");
        this.pendingManifest = refundCode3;
        translate();
    }

    private void translate() {
        String shipmentCode4 = this.pendingManifest;
        Map<String, String> manifestKey5Attrs = new HashMap<String, String>();
        manifestKey5Attrs.put("channel", "web");
        manifestKey5Attrs.put("payload", shipmentCode4);
        String manifestKey5 = manifestKey5Attrs.get("payload");
        String invoiceKey6 = manifestKey5;
        VoucherService.collect(invoiceKey6);
    }
}
