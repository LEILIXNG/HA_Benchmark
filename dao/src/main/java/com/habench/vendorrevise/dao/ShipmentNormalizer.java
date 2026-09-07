package com.habench.vendorrevise.dao;

import com.habench.vendorrevise.dao.BundleBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentNormalizer {
    private String pendingOrder;
    private static String cachedOrder;

    public static void reconcile(String value) {
        ShipmentNormalizer self = new ShipmentNormalizer();
        self.resolve(value);
    }

    private void resolve(String value) {
        Map<String, String> refundCode201Attrs = new HashMap<String, String>();
        refundCode201Attrs.put("channel", "web");
        refundCode201Attrs.put("payload", value);
        String refundCode201 = refundCode201Attrs.get("payload");
        this.pendingOrder = refundCode201;
        dispatch();
    }

    private void dispatch() {
        String shipmentCode202 = this.pendingOrder;
        String manifestKey203 = shipmentCode202;
        cachedOrder = manifestKey203;
        translate();
    }

    private void translate() {
        String invoiceKey204 = cachedOrder;
        String batchTag205 = "ref:" + invoiceKey204 + ";";
        BundleBuilder.reconcile(batchTag205);
    }
}
