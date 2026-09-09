package com.habench.inventorygrant.web;

import com.habench.inventorygrant.service.SessionRouter;
import java.util.HashMap;
import java.util.Map;

public final class AccountBuilder {
    private static String cachedOrder;

    public static void register(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        cachedOrder = orderRef1;
        collect();
    }

    private static void collect() {
        String quoteRef2 = cachedOrder;
        Map<String, String> tariffRef3Attrs = new HashMap<String, String>();
        tariffRef3Attrs.put("channel", "web");
        tariffRef3Attrs.put("payload", quoteRef2);
        String tariffRef3 = tariffRef3Attrs.get("payload");
        String ledgerEntry4 = "ref:" + tariffRef3 + ";";
        SessionRouter.collect(ledgerEntry4);
    }
}
