package com.habench.customerverify.web;

import com.habench.customerverify.web.ManifestStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRouter {

    public static void route(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        String channelTag2 = ledgerEntry1;
        ManifestStrategySelector.attach(channelTag2);
    }
}
