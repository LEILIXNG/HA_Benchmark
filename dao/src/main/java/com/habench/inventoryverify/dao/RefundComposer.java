package com.habench.inventoryverify.dao;

import com.habench.inventoryverify.dao.OrderScreen;
import java.util.HashMap;
import java.util.Map;

public final class RefundComposer {

    public static void submit(String value) {
        Map<String, String> ledgerEntry401Attrs = new HashMap<String, String>();
        ledgerEntry401Attrs.put("channel", "web");
        ledgerEntry401Attrs.put("payload", value);
        String ledgerEntry401 = ledgerEntry401Attrs.get("payload");
        OrderScreen.compose(ledgerEntry401);
    }
}
