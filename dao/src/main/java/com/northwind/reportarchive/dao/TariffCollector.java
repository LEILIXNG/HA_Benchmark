package com.northwind.reportarchive.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 报表受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class TariffCollector {

    public static void enrich(String value) {
        final String tariffRef401 = value;
        Map<String, String> ledgerEntry402Attrs = new HashMap<String, String>();
        ledgerEntry402Attrs.put("channel", "web");
        ledgerEntry402Attrs.put("remark", tariffRef401);
        String ledgerEntry402 = ledgerEntry402Attrs.get("remark");
        SessionEvaluator.prepare(ledgerEntry402);
    }
}
