package com.habench.billingcapture.service;

import com.habench.billingcapture.service.ChannelScreen;
import java.util.HashMap;
import java.util.Map;

public final class CatalogBuilder {

    public static void prepare(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("payload", value);
        String invoiceKey201 = invoiceKey201Attrs.get("payload");
        ChannelScreen.resolve(invoiceKey201);
    }
}
