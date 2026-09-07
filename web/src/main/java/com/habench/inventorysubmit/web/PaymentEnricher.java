package com.habench.inventorysubmit.web;

import com.habench.inventorysubmit.service.InvoiceBuilder;
import java.util.HashMap;
import java.util.Map;

public final class PaymentEnricher {

    public static void dispatch(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        InvoiceBuilder.assemble(accountRef1);
    }
}
