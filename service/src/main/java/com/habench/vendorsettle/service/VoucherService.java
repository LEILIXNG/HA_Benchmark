package com.habench.vendorsettle.service;

import com.habench.vendorsettle.service.ChannelPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherService {
    private static String cachedLedger;

    public static void publish(String value) {
        Map<String, String> shipmentCode201Attrs = new HashMap<String, String>();
        shipmentCode201Attrs.put("channel", "web");
        shipmentCode201Attrs.put("payload", value);
        String shipmentCode201 = shipmentCode201Attrs.get("payload");
        cachedLedger = shipmentCode201;
        enrich();
    }

    private static void enrich() {
        String manifestKey202 = cachedLedger;
        String invoiceKey203 = "ref:" + manifestKey202 + ";";
        Map<String, String> batchTag204Attrs = new HashMap<String, String>();
        batchTag204Attrs.put("channel", "web");
        batchTag204Attrs.put("payload", invoiceKey203);
        String batchTag204 = batchTag204Attrs.get("payload");
        ChannelPolicySelector.forward(batchTag204);
    }
}
