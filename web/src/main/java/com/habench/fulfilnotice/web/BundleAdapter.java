package com.habench.fulfilnotice.web;

import com.habench.fulfilnotice.service.InvoiceRegistry;
import java.util.HashMap;
import java.util.Map;

public final class BundleAdapter {

    public static void prepare(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("payload", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("payload");
        String channelTag102 = "ref:" + ledgerEntry101 + ";";
        InvoiceRegistry.expand(channelTag102);
    }
}
