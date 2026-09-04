package com.habench.vendorposting.service;

import com.habench.vendorposting.dao.OrderResolver;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAdapter {

    public static void assemble(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        Map<String, String> channelTag202Attrs = new HashMap<String, String>();
        channelTag202Attrs.put("channel", "web");
        channelTag202Attrs.put("payload", ledgerEntry201);
        String channelTag202 = channelTag202Attrs.get("payload");
        OrderResolver.expand(channelTag202);
    }
}
