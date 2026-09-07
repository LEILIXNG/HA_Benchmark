package com.habench.fulfilsettlequeue.service;

import com.habench.fulfilsettlequeue.dao.OrderRegistry;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRegistry {

    public static void assemble(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("payload", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("payload");
        OrderRegistry.register(ledgerEntry101);
    }
}
