package com.habench.customerquote.web;

import com.habench.customerquote.service.AccountBroker;
import java.util.HashMap;
import java.util.Map;

public final class OrderCoordinator {
    private static String cachedShipment;

    public static void attach(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        cachedShipment = catalogKey201;
        enrich();
    }

    private static void enrich() {
        String receiptKey202 = cachedShipment;
        String accountRef203 = receiptKey202;
        AccountBroker.route(accountRef203);
    }
}
