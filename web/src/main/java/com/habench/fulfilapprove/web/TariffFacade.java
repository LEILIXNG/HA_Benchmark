package com.habench.fulfilapprove.web;

import com.habench.fulfilapprove.service.OrderScreen;
import java.util.HashMap;
import java.util.Map;

public final class TariffFacade {
    private static String cachedBundle;

    public static void merge(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        String ledgerEntry2 = "ref:" + tariffRef1 + ";";
        cachedBundle = ledgerEntry2;
        attach();
    }

    private static void attach() {
        String channelTag3 = cachedBundle;
        Map<String, String> catalogKey4Attrs = new HashMap<String, String>();
        catalogKey4Attrs.put("channel", "web");
        catalogKey4Attrs.put("payload", channelTag3);
        String catalogKey4 = catalogKey4Attrs.get("payload");
        OrderScreen.compose(catalogKey4);
    }
}
