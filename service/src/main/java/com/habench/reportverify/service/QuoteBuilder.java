package com.habench.reportverify.service;

import com.habench.reportverify.service.AccountScreen;
import java.util.HashMap;
import java.util.Map;

public final class QuoteBuilder {

    public static void expand(String value) {
        String shipmentCode301 = "ref:" + value + ";";
        Map<String, String> manifestKey302Attrs = new HashMap<String, String>();
        manifestKey302Attrs.put("channel", "web");
        manifestKey302Attrs.put("payload", shipmentCode301);
        String manifestKey302 = manifestKey302Attrs.get("payload");
        AccountScreen.compose(manifestKey302);
    }
}
