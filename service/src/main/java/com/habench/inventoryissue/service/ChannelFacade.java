package com.habench.inventoryissue.service;

import com.habench.inventoryissue.dao.TariffRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ChannelFacade {
    private static String cachedManifest;

    public static void reconcile(String value) {
        String voucherRef101 = value;
        cachedManifest = voucherRef101;
        compose();
    }

    private static void compose() {
        String paymentTag102 = cachedManifest;
        Map<String, String> refundCode103Attrs = new HashMap<String, String>();
        refundCode103Attrs.put("channel", "web");
        refundCode103Attrs.put("payload", paymentTag102);
        String refundCode103 = refundCode103Attrs.get("payload");
        Map<String, String> shipmentCode104Attrs = new HashMap<String, String>();
        shipmentCode104Attrs.put("channel", "web");
        shipmentCode104Attrs.put("payload", refundCode103);
        String shipmentCode104 = shipmentCode104Attrs.get("payload");
        TariffRegistry.reconcile(shipmentCode104);
    }
}
