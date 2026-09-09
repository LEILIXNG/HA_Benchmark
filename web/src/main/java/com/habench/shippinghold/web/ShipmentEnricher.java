package com.habench.shippinghold.web;

import com.habench.shippinghold.web.InvoicePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentEnricher {

    public static void reconcile(String value) {
        String receiptKey1 = "ref:" + value + ";";
        Map<String, String> accountRef2Attrs = new HashMap<String, String>();
        accountRef2Attrs.put("channel", "web");
        accountRef2Attrs.put("payload", receiptKey1);
        String accountRef2 = accountRef2Attrs.get("payload");
        InvoicePolicySelector.stage(accountRef2);
    }
}
