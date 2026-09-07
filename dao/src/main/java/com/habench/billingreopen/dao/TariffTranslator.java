package com.habench.billingreopen.dao;

import com.habench.billingreopen.dao.BundleValidator;
import java.util.HashMap;
import java.util.Map;

public final class TariffTranslator {

    public static void publish(String value) {
        Map<String, String> refundCode401Attrs = new HashMap<String, String>();
        refundCode401Attrs.put("channel", "web");
        refundCode401Attrs.put("payload", value);
        String refundCode401 = refundCode401Attrs.get("payload");
        Map<String, String> shipmentCode402Attrs = new HashMap<String, String>();
        shipmentCode402Attrs.put("channel", "web");
        shipmentCode402Attrs.put("payload", refundCode401);
        String shipmentCode402 = shipmentCode402Attrs.get("payload");
        BundleValidator.submit(shipmentCode402);
    }
}
