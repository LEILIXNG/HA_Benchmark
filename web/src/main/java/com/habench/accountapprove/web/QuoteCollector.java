package com.habench.accountapprove.web;

import com.habench.accountapprove.service.ChannelEnricher;
import java.util.HashMap;
import java.util.Map;

public final class QuoteCollector {

    public static void normalize(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        String receiptKey202 = "ref:" + catalogKey201 + ";";
        ChannelEnricher.normalize(receiptKey202);
    }
}
