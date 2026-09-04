package com.habench.inventorydraft.service;

import com.habench.inventorydraft.service.QuotePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountService {

    public static void merge(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        String tariffRef202 = "ref:" + quoteRef201 + ";";
        QuotePolicySelector.enrich(tariffRef202);
    }
}
