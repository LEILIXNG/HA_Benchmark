package com.habench.shippingsubmit.web;

import com.habench.shippingsubmit.web.AccountRegistry;
import java.util.HashMap;
import java.util.Map;

public final class TariffEnricher {

    public static void expand(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("payload", value);
        String shipmentCode101 = shipmentCode101Attrs.get("payload");
        String manifestKey102 = shipmentCode101;
        AccountRegistry.collect(manifestKey102);
    }
}
