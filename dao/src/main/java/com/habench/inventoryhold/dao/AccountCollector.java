package com.habench.inventoryhold.dao;

import com.habench.inventoryhold.dao.BundleLoader;
import java.util.HashMap;
import java.util.Map;

public final class AccountCollector {

    public static void refine(String value) {
        Map<String, String> quoteRef301Attrs = new HashMap<String, String>();
        quoteRef301Attrs.put("channel", "web");
        quoteRef301Attrs.put("payload", value);
        String quoteRef301 = quoteRef301Attrs.get("payload");
        BundleLoader.stage(quoteRef301);
    }
}
