package com.habench.reportposting.web;

import com.habench.reportposting.web.LedgerStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffEnricher {

    public static void register(String value) {
        Map<String, String> quoteRef101Attrs = new HashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("payload", value);
        String quoteRef101 = quoteRef101Attrs.get("payload");
        LedgerStrategySelector.publish(quoteRef101);
    }
}
