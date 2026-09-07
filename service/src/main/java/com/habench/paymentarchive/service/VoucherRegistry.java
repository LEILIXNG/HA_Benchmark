package com.habench.paymentarchive.service;

import com.habench.paymentarchive.dao.SessionComposer;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRegistry {

    public static void merge(String value) {
        Map<String, String> channelTag201Attrs = new HashMap<String, String>();
        channelTag201Attrs.put("channel", "web");
        channelTag201Attrs.put("payload", value);
        String channelTag201 = channelTag201Attrs.get("payload");
        SessionComposer.collect(channelTag201);
    }
}
