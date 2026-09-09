package com.habench.customerposting.dao;

import com.habench.customerposting.dao.AccountStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class BatchTranslator {

    public static void collect(String value) {
        Map<String, String> orderRef401Attrs = new HashMap<String, String>();
        orderRef401Attrs.put("channel", "web");
        orderRef401Attrs.put("payload", value);
        String orderRef401 = orderRef401Attrs.get("payload");
        Map<String, String> quoteRef402Attrs = new HashMap<String, String>();
        quoteRef402Attrs.put("channel", "web");
        quoteRef402Attrs.put("payload", orderRef401);
        String quoteRef402 = quoteRef402Attrs.get("payload");
        AccountStrategySelector.prepare(quoteRef402);
    }
}
