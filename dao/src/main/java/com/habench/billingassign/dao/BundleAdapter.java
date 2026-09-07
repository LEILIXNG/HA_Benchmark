package com.habench.billingassign.dao;

import com.habench.billingassign.dao.TariffGuard;
import java.util.HashMap;
import java.util.Map;

public final class BundleAdapter {

    public static void stage(String value) {
        Map<String, String> catalogKey301Attrs = new HashMap<String, String>();
        catalogKey301Attrs.put("channel", "web");
        catalogKey301Attrs.put("payload", value);
        String catalogKey301 = catalogKey301Attrs.get("payload");
        String receiptKey302 = "ref:" + catalogKey301 + ";";
        TariffGuard.merge(receiptKey302);
    }
}
