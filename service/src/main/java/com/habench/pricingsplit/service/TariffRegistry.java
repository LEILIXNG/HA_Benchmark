package com.habench.pricingsplit.service;

import com.habench.pricingsplit.service.BundleRepository;
import java.util.HashMap;
import java.util.Map;

public final class TariffRegistry {

    public static void publish(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("payload", value);
        String invoiceKey201 = invoiceKey201Attrs.get("payload");
        String batchTag202 = invoiceKey201;
        BundleRepository.route(batchTag202);
    }
}
