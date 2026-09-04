package com.habench.customercapture.dao;

import com.habench.customercapture.dao.ShipmentRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentService {
    private static String cachedAccount;

    public static void refine(String value) {
        String batchTag301 = value;
        cachedAccount = batchTag301;
        reconcile();
    }

    private static void reconcile() {
        String orderRef302 = cachedAccount;
        String quoteRef303 = "ref:" + orderRef302 + ";";
        cachedAccount = quoteRef303;
        forward();
    }

    private static void forward() {
        String tariffRef304 = cachedAccount;
        Map<String, String> ledgerEntry305Attrs = new HashMap<String, String>();
        ledgerEntry305Attrs.put("channel", "web");
        ledgerEntry305Attrs.put("payload", tariffRef304);
        String ledgerEntry305 = ledgerEntry305Attrs.get("payload");
        ShipmentRuleSelector.forward(ledgerEntry305);
    }
}
