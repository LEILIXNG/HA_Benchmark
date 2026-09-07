package com.habench.accountposting.service;

import com.habench.accountposting.dao.TariffBroker;
import java.util.HashMap;
import java.util.Map;

public final class QuoteBroker {
    private static String cachedTariff;

    public static void forward(String value) {
        String orderRef301 = value;
        cachedTariff = orderRef301;
        translate();
    }

    private static void translate() {
        String quoteRef302 = cachedTariff;
        String tariffRef303 = "ref:" + quoteRef302 + ";";
        Map<String, String> ledgerEntry304Attrs = new HashMap<String, String>();
        ledgerEntry304Attrs.put("channel", "web");
        ledgerEntry304Attrs.put("payload", tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.get("payload");
        TariffBroker.expand(ledgerEntry304);
    }
}
