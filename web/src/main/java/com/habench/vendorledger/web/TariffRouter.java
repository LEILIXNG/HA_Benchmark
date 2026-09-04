package com.habench.vendorledger.web;

import com.habench.vendorledger.service.LedgerCollector;
import java.util.HashMap;
import java.util.Map;

public final class TariffRouter {

    public static void stage(String value) {
        String channelTag1 = value;
        Map<String, String> catalogKey2Attrs = new HashMap<String, String>();
        catalogKey2Attrs.put("channel", "web");
        catalogKey2Attrs.put("payload", channelTag1);
        String catalogKey2 = catalogKey2Attrs.get("payload");
        LedgerCollector.dispatch(catalogKey2);
    }
}
