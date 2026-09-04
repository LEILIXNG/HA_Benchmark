package com.habench.vendorquote.service;

import com.habench.vendorquote.dao.QuoteService;
import java.util.HashMap;
import java.util.Map;

public final class AccountNormalizer {

    public static void compose(String value) {
        String shipmentCode301 = "ref:" + value + ";";
        Map<String, String> manifestKey302Attrs = new HashMap<String, String>();
        manifestKey302Attrs.put("channel", "web");
        manifestKey302Attrs.put("payload", shipmentCode301);
        String manifestKey302 = manifestKey302Attrs.get("payload");
        QuoteService.compose(manifestKey302);
    }
}
