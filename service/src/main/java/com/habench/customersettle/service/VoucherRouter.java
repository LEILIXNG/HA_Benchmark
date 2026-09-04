package com.habench.customersettle.service;

import com.habench.customersettle.dao.ChannelResolver;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRouter {

    public static void attach(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        ChannelResolver.register(quoteRef201);
    }
}
