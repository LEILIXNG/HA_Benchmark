package com.habench.accountrollup.service;

import com.habench.accountrollup.dao.BundleAdapter;
import java.util.HashMap;
import java.util.Map;

public final class BundleAdapter2 {

    public static void register(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        BundleAdapter.submit(invoiceKey101);
    }
}
