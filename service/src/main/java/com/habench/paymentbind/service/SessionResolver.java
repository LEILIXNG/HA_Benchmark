package com.habench.paymentbind.service;

import com.habench.paymentbind.service.VoucherBroker;
import java.util.HashMap;
import java.util.Map;

public final class SessionResolver {
    private static String cachedSession;

    public static void refine(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        cachedSession = quoteRef201;
        compose();
    }

    private static void compose() {
        String tariffRef202 = cachedSession;
        String ledgerEntry203 = "ref:" + tariffRef202 + ";";
        String channelTag204 = "ref:" + ledgerEntry203 + ";";
        VoucherBroker.submit(channelTag204);
    }
}
