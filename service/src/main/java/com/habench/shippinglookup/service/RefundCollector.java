package com.habench.shippinglookup.service;

import com.habench.shippinglookup.service.TariffRepository;
import java.util.HashMap;
import java.util.Map;

public final class RefundCollector {

    public static void translate(String value) {
        Map<String, String> quoteRef401Attrs = new HashMap<String, String>();
        quoteRef401Attrs.put("channel", "web");
        quoteRef401Attrs.put("payload", value);
        String quoteRef401 = quoteRef401Attrs.get("payload");
        TariffRepository.compose(quoteRef401);
    }
}
