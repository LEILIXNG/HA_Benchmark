package com.habench.pricingadjust.service;

import com.habench.pricingadjust.service.ManifestCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class CatalogBroker {
    private static String cachedSession;

    public static void stage(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        String tariffRef202 = "ref:" + quoteRef201 + ";";
        cachedSession = tariffRef202;
        compose();
    }

    private static void compose() {
        String ledgerEntry203 = cachedSession;
        String channelTag204 = ledgerEntry203;
        Map<String, String> catalogKey205Attrs = new HashMap<String, String>();
        catalogKey205Attrs.put("channel", "web");
        catalogKey205Attrs.put("payload", channelTag204);
        String catalogKey205 = catalogKey205Attrs.get("payload");
        ManifestCoordinator.dispatch(catalogKey205);
    }
}
