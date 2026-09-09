package com.habench.shippingreopen.service;

import com.habench.shippingreopen.service.InvoiceRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteBroker {

    public static void assemble(String value) {
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("payload", value);
        String manifestKey101 = manifestKey101Attrs.get("payload");
        InvoiceRuleSelector.expand(manifestKey101);
    }
}
