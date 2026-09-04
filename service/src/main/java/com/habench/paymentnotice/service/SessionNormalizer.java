package com.habench.paymentnotice.service;

import com.habench.paymentnotice.service.ChannelScreen;
import java.util.HashMap;
import java.util.Map;

public final class SessionNormalizer {

    public static void stage(String value) {
        Map<String, String> catalogKey501Attrs = new HashMap<String, String>();
        catalogKey501Attrs.put("channel", "web");
        catalogKey501Attrs.put("payload", value);
        String catalogKey501 = catalogKey501Attrs.get("payload");
        Map<String, String> receiptKey502Attrs = new HashMap<String, String>();
        receiptKey502Attrs.put("channel", "web");
        receiptKey502Attrs.put("payload", catalogKey501);
        String receiptKey502 = receiptKey502Attrs.get("payload");
        ChannelScreen.stage(receiptKey502);
    }
}
