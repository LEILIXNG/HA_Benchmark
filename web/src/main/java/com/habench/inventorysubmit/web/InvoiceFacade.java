package com.habench.inventorysubmit.web;

import com.habench.inventorysubmit.web.PaymentPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceFacade {

    public static void refine(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        PaymentPolicySelector.collect(accountRef1);
    }
}
