package com.habench.inventorybind.dao;

import com.habench.inventorybind.dao.BatchGuard;
import java.util.HashMap;
import java.util.Map;

public final class ChannelFacade {
    private static String cachedContract;

    public static void expand(String value) {
        String orderRef301 = value;
        cachedContract = orderRef301;
        collect();
    }

    private static void collect() {
        String quoteRef302 = cachedContract;
        String tariffRef303 = "ref:" + quoteRef302 + ";";
        Map<String, String> ledgerEntry304Attrs = new HashMap<String, String>();
        ledgerEntry304Attrs.put("channel", "web");
        ledgerEntry304Attrs.put("payload", tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.get("payload");
        BatchGuard.merge(ledgerEntry304);
    }
}
