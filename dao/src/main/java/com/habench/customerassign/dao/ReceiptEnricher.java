package com.habench.customerassign.dao;

import com.habench.customerassign.dao.CatalogScreen;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptEnricher {

    public static void prepare(String value) {
        Map<String, String> ledgerEntry301Attrs = new HashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("payload", value);
        String ledgerEntry301 = ledgerEntry301Attrs.get("payload");
        CatalogScreen.reconcile(ledgerEntry301);
    }
}
