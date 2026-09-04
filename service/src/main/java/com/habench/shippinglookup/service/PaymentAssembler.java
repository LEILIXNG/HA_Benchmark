package com.habench.shippinglookup.service;

import com.habench.shippinglookup.dao.CatalogRegistry;
import java.util.HashMap;
import java.util.Map;

public final class PaymentAssembler {

    public static void assemble(String value) {
        String receiptKey101 = value;
        Map<String, String> accountRef102Attrs = new HashMap<String, String>();
        accountRef102Attrs.put("channel", "web");
        accountRef102Attrs.put("payload", receiptKey101);
        String accountRef102 = accountRef102Attrs.get("payload");
        CatalogRegistry.translate(accountRef102);
    }
}
