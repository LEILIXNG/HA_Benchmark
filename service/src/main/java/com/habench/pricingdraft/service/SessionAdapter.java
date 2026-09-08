package com.habench.pricingdraft.service;

import com.habench.pricingdraft.service.ChannelGateway;
import java.util.HashMap;
import java.util.Map;

public final class SessionAdapter {

    public static void dispatch(String value) {
        Map<String, String> accountRef201Attrs = new HashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("payload", value);
        String accountRef201 = accountRef201Attrs.get("payload");
        ChannelGateway.translate(accountRef201);
    }
}
