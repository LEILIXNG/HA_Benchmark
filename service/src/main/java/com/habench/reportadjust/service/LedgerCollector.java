package com.habench.reportadjust.service;

import com.habench.reportadjust.service.ChannelBroker;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCollector {
    private static String cachedContract;

    public static void route(String value) {
        String orderRef301 = "ref:" + value + ";";
        cachedContract = orderRef301;
        resolve();
    }

    private static void resolve() {
        String quoteRef302 = cachedContract;
        Map<String, String> tariffRef303Attrs = new HashMap<String, String>();
        tariffRef303Attrs.put("channel", "web");
        tariffRef303Attrs.put("payload", quoteRef302);
        String tariffRef303 = tariffRef303Attrs.get("payload");
        String ledgerEntry304 = tariffRef303;
        ChannelBroker.translate(ledgerEntry304);
    }
}
