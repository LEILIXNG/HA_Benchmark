package com.habench.pricingrevise.web;

import com.habench.pricingrevise.service.PaymentTranslator;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentService {
    private static String cachedCatalog;

    public static void merge(String value) {
        String tariffRef201 = value;
        cachedCatalog = tariffRef201;
        attach();
    }

    private static void attach() {
        String ledgerEntry202 = cachedCatalog;
        Map<String, String> channelTag203Attrs = new HashMap<String, String>();
        channelTag203Attrs.put("channel", "web");
        channelTag203Attrs.put("payload", ledgerEntry202);
        String channelTag203 = channelTag203Attrs.get("payload");
        String catalogKey204 = "ref:" + channelTag203 + ";";
        cachedCatalog = catalogKey204;
        refine();
    }

    private static void refine() {
        String receiptKey205 = cachedCatalog;
        String accountRef206 = "ref:" + receiptKey205 + ";";
        PaymentTranslator.merge(accountRef206);
    }
}
