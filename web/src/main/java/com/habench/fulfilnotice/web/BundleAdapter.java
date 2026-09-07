package com.habench.fulfilnotice.web;

import com.habench.fulfilnotice.service.InvoiceRegistry;
import java.util.HashMap;
import java.util.Map;

public final class BundleAdapter {

    public static void prepare(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        Map<String, String> channelTag102Attrs = new HashMap<String, String>();
        channelTag102Attrs.put("channel", "web");
        channelTag102Attrs.put("payload", ledgerEntry101);
        String channelTag102 = channelTag102Attrs.get("payload");
        InvoiceRegistry.expand(channelTag102);
    }
}
