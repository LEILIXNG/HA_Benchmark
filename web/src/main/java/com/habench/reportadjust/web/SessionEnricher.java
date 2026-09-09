package com.habench.reportadjust.web;

import com.habench.reportadjust.service.LedgerCollector;
import java.util.HashMap;
import java.util.Map;

public final class SessionEnricher {

    public static void dispatch(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        LedgerCollector.route(catalogKey201);
    }
}
