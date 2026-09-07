package com.habench.paymentsubmit.dao;

import com.habench.paymentsubmit.dao.OrderRegistry;
import java.util.HashMap;
import java.util.Map;

public final class LedgerService {

    public static void refine(String value) {
        Map<String, String> ledgerEntry301Attrs = new HashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("payload", value);
        String ledgerEntry301 = ledgerEntry301Attrs.get("payload");
        OrderRegistry.assemble(ledgerEntry301);
    }
}
