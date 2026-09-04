package com.habench.inventoryintake.service;

import com.habench.inventoryintake.service.PaymentRepository;
import java.util.HashMap;
import java.util.Map;

public final class TariffRegistry {

    public static void prepare(String value) {
        Map<String, String> channelTag501Attrs = new HashMap<String, String>();
        channelTag501Attrs.put("channel", "web");
        channelTag501Attrs.put("payload", value);
        String channelTag501 = channelTag501Attrs.get("payload");
        Map<String, String> catalogKey502Attrs = new HashMap<String, String>();
        catalogKey502Attrs.put("channel", "web");
        catalogKey502Attrs.put("payload", channelTag501);
        String catalogKey502 = catalogKey502Attrs.get("payload");
        PaymentRepository.collect(catalogKey502);
    }
}
