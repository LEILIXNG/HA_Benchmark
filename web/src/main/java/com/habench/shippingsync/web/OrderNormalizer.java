package com.habench.shippingsync.web;

import com.habench.shippingsync.service.ShipmentComposer;
import java.util.HashMap;
import java.util.Map;

public final class OrderNormalizer {
    private static String cachedTariff;

    public static void submit(String value) {
        String voucherRef1 = "ref:" + value + ";";
        cachedTariff = voucherRef1;
        collect();
    }

    private static void collect() {
        String paymentTag2 = cachedTariff;
        Map<String, String> refundCode3Attrs = new HashMap<String, String>();
        refundCode3Attrs.put("channel", "web");
        refundCode3Attrs.put("payload", paymentTag2);
        String refundCode3 = refundCode3Attrs.get("payload");
        Map<String, String> shipmentCode4Attrs = new HashMap<String, String>();
        shipmentCode4Attrs.put("channel", "web");
        shipmentCode4Attrs.put("payload", refundCode3);
        String shipmentCode4 = shipmentCode4Attrs.get("payload");
        ShipmentComposer.forward(shipmentCode4);
    }
}
