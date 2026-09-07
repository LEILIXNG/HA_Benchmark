package com.habench.paymenthold.service;

import com.habench.paymenthold.dao.BundleComposer;
import java.util.HashMap;
import java.util.Map;

public final class AccountResolver {

    public static void submit(String value) {
        String channelTag301 = "ref:" + value + ";";
        Map<String, String> catalogKey302Attrs = new HashMap<String, String>();
        catalogKey302Attrs.put("channel", "web");
        catalogKey302Attrs.put("payload", channelTag301);
        String catalogKey302 = catalogKey302Attrs.get("payload");
        BundleComposer.forward(catalogKey302);
    }
}
