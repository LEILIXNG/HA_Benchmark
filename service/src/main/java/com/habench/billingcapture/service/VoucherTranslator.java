package com.habench.billingcapture.service;

import com.habench.billingcapture.service.CatalogBuilder;
import java.util.HashMap;
import java.util.Map;

public final class VoucherTranslator {

    public static void forward(String value) {
        String ledgerEntry101 = value;
        Map<String, String> channelTag102Attrs = new HashMap<String, String>();
        channelTag102Attrs.put("channel", "web");
        channelTag102Attrs.put("payload", ledgerEntry101);
        String channelTag102 = channelTag102Attrs.get("payload");
        CatalogBuilder.prepare(channelTag102);
    }
}
