package com.habench.fulfilverify.dao;

import com.habench.fulfilverify.dao.InvoiceFilter;
import java.util.HashMap;
import java.util.Map;

public final class AccountAdapter {

    public static void normalize(String value) {
        String manifestKey401 = value;
        Map<String, String> invoiceKey402Attrs = new HashMap<String, String>();
        invoiceKey402Attrs.put("channel", "web");
        invoiceKey402Attrs.put("payload", manifestKey401);
        String invoiceKey402 = invoiceKey402Attrs.get("payload");
        InvoiceFilter.compose(invoiceKey402);
    }
}
