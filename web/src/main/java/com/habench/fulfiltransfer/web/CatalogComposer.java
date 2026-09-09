package com.habench.fulfiltransfer.web;

import com.habench.fulfiltransfer.service.PaymentAdapter;
import java.util.HashMap;
import java.util.Map;

public final class CatalogComposer {
    private static String cachedBundle;

    public static void submit(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        String tariffRef2 = quoteRef1;
        cachedBundle = tariffRef2;
        assemble();
    }

    private static void assemble() {
        String ledgerEntry3 = cachedBundle;
        String channelTag4 = "ref:" + ledgerEntry3 + ";";
        PaymentAdapter.translate(channelTag4);
    }
}
