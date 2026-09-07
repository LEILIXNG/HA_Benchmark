package com.habench.vendorissue.web;

import com.habench.vendorissue.service.ChannelCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class VoucherBuilder {

    public static void enrich(String value) {
        Map<String, String> orderRef201Attrs = new HashMap<String, String>();
        orderRef201Attrs.put("channel", "web");
        orderRef201Attrs.put("payload", value);
        String orderRef201 = orderRef201Attrs.get("payload");
        Map<String, String> quoteRef202Attrs = new HashMap<String, String>();
        quoteRef202Attrs.put("channel", "web");
        quoteRef202Attrs.put("payload", orderRef201);
        String quoteRef202 = quoteRef202Attrs.get("payload");
        ChannelCoordinator.resolve(quoteRef202);
    }
}
