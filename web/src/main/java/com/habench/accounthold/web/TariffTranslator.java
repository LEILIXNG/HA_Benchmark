package com.habench.accounthold.web;

import com.habench.accounthold.service.CatalogAdapter;
import java.util.HashMap;
import java.util.Map;

public final class TariffTranslator {
    private static String cachedSession;

    public static void publish(String value) {
        String orderRef1 = "ref:" + value + ";";
        cachedSession = orderRef1;
        collect();
    }

    private static void collect() {
        String quoteRef2 = cachedSession;
        Map<String, String> tariffRef3Attrs = new HashMap<String, String>();
        tariffRef3Attrs.put("channel", "web");
        tariffRef3Attrs.put("payload", quoteRef2);
        String tariffRef3 = tariffRef3Attrs.get("payload");
        Map<String, String> ledgerEntry4Attrs = new HashMap<String, String>();
        ledgerEntry4Attrs.put("channel", "web");
        ledgerEntry4Attrs.put("payload", tariffRef3);
        String ledgerEntry4 = ledgerEntry4Attrs.get("payload");
        CatalogAdapter.submit(ledgerEntry4);
    }
}
