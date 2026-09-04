package com.habench.shippingclose.web;

import com.habench.shippingclose.service.ContractEnricher;
import java.util.HashMap;
import java.util.Map;

public final class SessionRegistry {

    public static void forward(String value) {
        Map<String, String> quoteRef301Attrs = new HashMap<String, String>();
        quoteRef301Attrs.put("channel", "web");
        quoteRef301Attrs.put("payload", value);
        String quoteRef301 = quoteRef301Attrs.get("payload");
        String tariffRef302 = quoteRef301;
        ContractEnricher.expand(tariffRef302);
    }
}
