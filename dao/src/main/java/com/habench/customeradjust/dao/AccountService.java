package com.habench.customeradjust.dao;

import com.habench.customeradjust.dao.BundleEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class AccountService {

    public static void prepare(String value) {
        Map<String, String> manifestKey401Attrs = new HashMap<String, String>();
        manifestKey401Attrs.put("channel", "web");
        manifestKey401Attrs.put("payload", value);
        String manifestKey401 = manifestKey401Attrs.get("payload");
        Map<String, String> invoiceKey402Attrs = new HashMap<String, String>();
        invoiceKey402Attrs.put("channel", "web");
        invoiceKey402Attrs.put("payload", manifestKey401);
        String invoiceKey402 = invoiceKey402Attrs.get("payload");
        BundleEvaluator.resolve(invoiceKey402);
    }
}
