package com.habench.vendornotice.web;

import com.habench.vendornotice.service.PaymentAssembler;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentAdapter {

    public static void translate(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        Map<String, String> channelTag2Attrs = new HashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("payload", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.get("payload");
        PaymentAssembler.refine(channelTag2);
    }
}
