package com.habench.ordermanifest.service;

import com.habench.ordermanifest.dao.ChannelResolver;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptService {

    public static void expand(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("payload", value);
        String shipmentCode101 = shipmentCode101Attrs.get("payload");
        Map<String, String> manifestKey102Attrs = new HashMap<String, String>();
        manifestKey102Attrs.put("channel", "web");
        manifestKey102Attrs.put("payload", shipmentCode101);
        String manifestKey102 = manifestKey102Attrs.get("payload");
        ChannelResolver.refine(manifestKey102);
    }
}
