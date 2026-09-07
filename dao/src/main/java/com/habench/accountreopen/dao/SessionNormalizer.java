package com.habench.accountreopen.dao;

import com.habench.accountreopen.dao.SessionEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class SessionNormalizer {

    public static void submit(String value) {
        Map<String, String> ledgerEntry501Attrs = new HashMap<String, String>();
        ledgerEntry501Attrs.put("channel", "web");
        ledgerEntry501Attrs.put("payload", value);
        String ledgerEntry501 = ledgerEntry501Attrs.get("payload");
        SessionEvaluator.resolve(ledgerEntry501);
    }
}
