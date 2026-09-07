package com.habench.fulfilissue.web;

import com.habench.fulfilissue.web.TariffRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBroker {

    public static void translate(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        String batchTag2 = invoiceKey1;
        TariffRuleSelector.merge(batchTag2);
    }
}
