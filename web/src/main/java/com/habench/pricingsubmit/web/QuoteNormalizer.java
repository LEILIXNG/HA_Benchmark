package com.habench.pricingsubmit.web;

import com.habench.pricingsubmit.service.CatalogRouter;
import java.util.HashMap;
import java.util.Map;

public final class QuoteNormalizer {
    private static String cachedTariff;

    public static void expand(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        cachedTariff = ledgerEntry1;
        refine();
    }

    private static void refine() {
        String channelTag2 = cachedTariff;
        Map<String, String> catalogKey3Attrs = new HashMap<String, String>();
        catalogKey3Attrs.put("channel", "web");
        catalogKey3Attrs.put("payload", channelTag2);
        String catalogKey3 = catalogKey3Attrs.get("payload");
        CatalogRouter.attach(catalogKey3);
    }
}
