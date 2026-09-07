package com.habench.pricingrenewal.service;

import com.habench.pricingrenewal.service.CatalogStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteService {

    public static void register(String value) {
        Map<String, String> tariffRef201Attrs = new HashMap<String, String>();
        tariffRef201Attrs.put("channel", "web");
        tariffRef201Attrs.put("payload", value);
        String tariffRef201 = tariffRef201Attrs.get("payload");
        String ledgerEntry202 = "ref:" + tariffRef201 + ";";
        CatalogStrategySelector.expand(ledgerEntry202);
    }
}
