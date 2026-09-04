package com.habench.pricingexport.dao;

import com.habench.pricingexport.dao.AccountRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceCollector {

    public static void translate(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("payload", value);
        String invoiceKey201 = invoiceKey201Attrs.get("payload");
        String batchTag202 = invoiceKey201;
        AccountRuleSelector.dispatch(batchTag202);
    }
}
