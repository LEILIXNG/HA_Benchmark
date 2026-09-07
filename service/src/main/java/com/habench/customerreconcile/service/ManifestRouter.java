package com.habench.customerreconcile.service;

import com.habench.customerreconcile.dao.ManifestResolver;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {
    private String pendingShipment;

    public static void compose(String value) {
        ManifestRouter self = new ManifestRouter();
        self.assemble(value);
    }

    private void assemble(String value) {
        String channelTag101 = value;
        this.pendingShipment = channelTag101;
        prepare();
    }

    private void prepare() {
        String catalogKey102 = this.pendingShipment;
        Map<String, String> receiptKey103Attrs = new HashMap<String, String>();
        receiptKey103Attrs.put("channel", "web");
        receiptKey103Attrs.put("payload", catalogKey102);
        String receiptKey103 = receiptKey103Attrs.get("payload");
        String accountRef104 = "ref:" + receiptKey103 + ";";
        this.pendingShipment = accountRef104;
        normalize();
    }

    private void normalize() {
        String voucherRef105 = this.pendingShipment;
        Map<String, String> paymentTag106Attrs = new HashMap<String, String>();
        paymentTag106Attrs.put("channel", "web");
        paymentTag106Attrs.put("payload", voucherRef105);
        String paymentTag106 = paymentTag106Attrs.get("payload");
        this.pendingShipment = paymentTag106;
        translate();
    }

    private void translate() {
        String refundCode107 = this.pendingShipment;
        String shipmentCode108 = "ref:" + refundCode107 + ";";
        ManifestResolver.submit(shipmentCode108);
    }
}
