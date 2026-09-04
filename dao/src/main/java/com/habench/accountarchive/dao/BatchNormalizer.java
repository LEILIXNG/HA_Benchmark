package com.habench.accountarchive.dao;

import com.habench.accountarchive.dao.QuoteGuard;
import java.util.HashMap;
import java.util.Map;

public final class BatchNormalizer {

    public static void compose(String value) {
        Map<String, String> ledgerEntry301Attrs = new HashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("payload", value);
        String ledgerEntry301 = ledgerEntry301Attrs.get("payload");
        QuoteGuard.compose(ledgerEntry301);
    }
}
