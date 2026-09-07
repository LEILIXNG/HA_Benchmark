package com.habench.shippingexport.service;

import com.habench.shippingexport.service.ShipmentGuard;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCoordinator {
    private String pendingVoucher;

    public static void stage(String value) {
        ReceiptCoordinator self = new ReceiptCoordinator();
        self.register(value);
    }

    private void register(String value) {
        Map<String, String> refundCode201Attrs = new HashMap<String, String>();
        refundCode201Attrs.put("channel", "web");
        refundCode201Attrs.put("payload", value);
        String refundCode201 = refundCode201Attrs.get("payload");
        this.pendingVoucher = refundCode201;
        resolve();
    }

    private void resolve() {
        String shipmentCode202 = this.pendingVoucher;
        Map<String, String> manifestKey203Attrs = new HashMap<String, String>();
        manifestKey203Attrs.put("channel", "web");
        manifestKey203Attrs.put("payload", shipmentCode202);
        String manifestKey203 = manifestKey203Attrs.get("payload");
        Map<String, String> invoiceKey204Attrs = new HashMap<String, String>();
        invoiceKey204Attrs.put("channel", "web");
        invoiceKey204Attrs.put("payload", manifestKey203);
        String invoiceKey204 = invoiceKey204Attrs.get("payload");
        ShipmentGuard.dispatch(invoiceKey204);
    }
}
