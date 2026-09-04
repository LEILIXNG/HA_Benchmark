package com.habench.orderissue.web;

import com.habench.orderissue.service.ChannelValidator;
import java.util.HashMap;
import java.util.Map;

public final class SessionBuilder {

    public static void normalize(String value) {
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("payload", value);
        String receiptKey1 = receiptKey1Attrs.get("payload");
        ChannelValidator.register(receiptKey1);
    }
}
