package com.habench.reportsplit.dao;

import com.habench.reportsplit.dao.VoucherRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRouter {

    public static void stage(String value) {
        Map<String, String> manifestKey401Attrs = new HashMap<String, String>();
        manifestKey401Attrs.put("channel", "web");
        manifestKey401Attrs.put("payload", value);
        String manifestKey401 = manifestKey401Attrs.get("payload");
        String invoiceKey402 = manifestKey401;
        VoucherRuleSelector.translate(invoiceKey402);
    }
}
