package com.habench.ordertrace.web;

import com.habench.ordertrace.web.InvoiceRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class OrderBroker {

    public static void publish(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("payload", value);
        String invoiceKey201 = invoiceKey201Attrs.get("payload");
        String batchTag202 = "ref:" + invoiceKey201 + ";";
        InvoiceRuleSelector.normalize(batchTag202);
    }
}
