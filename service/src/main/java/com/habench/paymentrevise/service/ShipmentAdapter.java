package com.habench.paymentrevise.service;

import com.habench.paymentrevise.service.InvoiceRepository;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentAdapter {

    public static void forward(String value) {
        Map<String, String> channelTag201Attrs = new HashMap<String, String>();
        channelTag201Attrs.put("channel", "web");
        channelTag201Attrs.put("payload", value);
        String channelTag201 = channelTag201Attrs.get("payload");
        InvoiceRepository.normalize(channelTag201);
    }
}
