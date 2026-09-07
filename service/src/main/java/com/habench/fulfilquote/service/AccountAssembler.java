package com.habench.fulfilquote.service;

import com.habench.fulfilquote.dao.OrderCollector;
import java.util.HashMap;
import java.util.Map;

public final class AccountAssembler {
    private static String cachedTariff;

    public static void compose(String value) {
        String tariffRef201 = "ref:" + value + ";";
        Map<String, String> ledgerEntry202Attrs = new HashMap<String, String>();
        ledgerEntry202Attrs.put("channel", "web");
        ledgerEntry202Attrs.put("payload", tariffRef201);
        String ledgerEntry202 = ledgerEntry202Attrs.get("payload");
        cachedTariff = ledgerEntry202;
        enrich();
    }

    private static void enrich() {
        String channelTag203 = cachedTariff;
        String catalogKey204 = channelTag203;
        OrderCollector.translate(catalogKey204);
    }
}
