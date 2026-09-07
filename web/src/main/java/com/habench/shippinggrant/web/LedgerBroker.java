package com.habench.shippinggrant.web;

import com.habench.shippinggrant.service.TariffAdapter;
import java.util.HashMap;
import java.util.Map;

public final class LedgerBroker {

    public static void prepare(String value) {
        String receiptKey101 = value;
        Map<String, String> accountRef102Attrs = new HashMap<String, String>();
        accountRef102Attrs.put("channel", "web");
        accountRef102Attrs.put("payload", receiptKey101);
        String accountRef102 = accountRef102Attrs.get("payload");
        TariffAdapter.publish(accountRef102);
    }
}
