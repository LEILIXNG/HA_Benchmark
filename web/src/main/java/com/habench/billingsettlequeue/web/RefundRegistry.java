package com.habench.billingsettlequeue.web;

import com.habench.billingsettlequeue.web.PaymentTranslator;
import java.util.HashMap;
import java.util.Map;

public final class RefundRegistry {
    private static String cachedTariff;

    public static void translate(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        cachedTariff = quoteRef1;
        resolve();
    }

    private static void resolve() {
        String tariffRef2 = cachedTariff;
        String ledgerEntry3 = tariffRef2;
        String channelTag4 = ledgerEntry3;
        PaymentTranslator.merge(channelTag4);
    }
}
