package com.habench.catalogassign.web;

import com.habench.catalogassign.web.QuoteRouter;
import java.util.HashMap;
import java.util.Map;

public final class QuoteRegistry {

    public static void reconcile(String value) {
        String tariffRef1 = value;
        Map<String, String> ledgerEntry2Attrs = new HashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("payload", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get("payload");
        QuoteRouter.normalize(ledgerEntry2);
    }
}
