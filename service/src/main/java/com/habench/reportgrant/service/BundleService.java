package com.habench.reportgrant.service;

import com.habench.reportgrant.dao.QuoteRouter;
import java.util.HashMap;
import java.util.Map;

public final class BundleService {
    private static String cachedOrder;

    public static void collect(String value) {
        String batchTag101 = value;
        String orderRef102 = "ref:" + batchTag101 + ";";
        cachedOrder = orderRef102;
        refine();
    }

    private static void refine() {
        String quoteRef103 = cachedOrder;
        String tariffRef104 = quoteRef103;
        Map<String, String> ledgerEntry105Attrs = new HashMap<String, String>();
        ledgerEntry105Attrs.put("channel", "web");
        ledgerEntry105Attrs.put("payload", tariffRef104);
        String ledgerEntry105 = ledgerEntry105Attrs.get("payload");
        QuoteRouter.compose(ledgerEntry105);
    }
}
