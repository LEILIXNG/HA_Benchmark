package com.habench.billingrelease.service;

import com.habench.billingrelease.service.ChannelService;
import java.util.HashMap;
import java.util.Map;

public final class ContractBroker {

    public static void translate(String value) {
        String orderRef301 = value;
        Map<String, String> quoteRef302Attrs = new HashMap<String, String>();
        quoteRef302Attrs.put("channel", "web");
        quoteRef302Attrs.put("payload", orderRef301);
        String quoteRef302 = quoteRef302Attrs.get("payload");
        ChannelService.attach(quoteRef302);
    }
}
