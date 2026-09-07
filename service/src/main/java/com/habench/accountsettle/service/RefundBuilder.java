package com.habench.accountsettle.service;

import com.habench.accountsettle.dao.ReceiptResolver;
import java.util.HashMap;
import java.util.Map;

public final class RefundBuilder {

    public static void forward(String value) {
        String channelTag101 = "ref:" + value + ";";
        Map<String, String> catalogKey102Attrs = new HashMap<String, String>();
        catalogKey102Attrs.put("channel", "web");
        catalogKey102Attrs.put("payload", channelTag101);
        String catalogKey102 = catalogKey102Attrs.get("payload");
        ReceiptResolver.attach(catalogKey102);
    }
}
