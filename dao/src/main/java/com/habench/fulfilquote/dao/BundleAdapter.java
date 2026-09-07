package com.habench.fulfilquote.dao;

import com.habench.fulfilquote.dao.TariffExecutor;
import java.util.HashMap;
import java.util.Map;

public final class BundleAdapter {

    public static void assemble(String value) {
        Map<String, String> manifestKey301Attrs = new HashMap<String, String>();
        manifestKey301Attrs.put("channel", "web");
        manifestKey301Attrs.put("payload", value);
        String manifestKey301 = manifestKey301Attrs.get("payload");
        String invoiceKey302 = manifestKey301;
        TariffExecutor.prepare(invoiceKey302);
    }
}
