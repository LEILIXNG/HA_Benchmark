package com.habench.reportsettle.web;

import com.habench.reportsettle.web.RefundEnricher;
import java.util.HashMap;
import java.util.Map;

public final class VoucherCollector {

    public static void prepare(String value) {
        Map<String, String> catalogKey101Attrs = new HashMap<String, String>();
        catalogKey101Attrs.put("channel", "web");
        catalogKey101Attrs.put("payload", value);
        String catalogKey101 = catalogKey101Attrs.get("payload");
        RefundEnricher.refine(catalogKey101);
    }
}
