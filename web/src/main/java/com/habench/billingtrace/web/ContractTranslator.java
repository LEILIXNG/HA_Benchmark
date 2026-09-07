package com.habench.billingtrace.web;

import com.habench.billingtrace.service.AccountEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ContractTranslator {

    public static void register(String value) {
        String ledgerEntry1 = value;
        Map<String, String> channelTag2Attrs = new HashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("payload", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.get("payload");
        AccountEnricher.attach(channelTag2);
    }
}
