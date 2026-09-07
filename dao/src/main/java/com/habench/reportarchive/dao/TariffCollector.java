package com.habench.reportarchive.dao;

import com.habench.reportarchive.dao.SessionEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class TariffCollector {

    public static void enrich(String value) {
        String tariffRef401 = value;
        Map<String, String> ledgerEntry402Attrs = new HashMap<String, String>();
        ledgerEntry402Attrs.put("channel", "web");
        ledgerEntry402Attrs.put("payload", tariffRef401);
        String ledgerEntry402 = ledgerEntry402Attrs.get("payload");
        SessionEvaluator.prepare(ledgerEntry402);
    }
}
