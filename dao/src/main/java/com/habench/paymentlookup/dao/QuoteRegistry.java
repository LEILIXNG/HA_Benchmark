package com.habench.paymentlookup.dao;

import com.habench.paymentlookup.dao.SessionGateway;
import java.util.HashMap;
import java.util.Map;

public final class QuoteRegistry {
    private static String cachedSession;

    public static void refine(String value) {
        String batchTag301 = "ref:" + value + ";";
        String orderRef302 = batchTag301;
        cachedSession = orderRef302;
        stage();
    }

    private static void stage() {
        String quoteRef303 = cachedSession;
        Map<String, String> tariffRef304Attrs = new HashMap<String, String>();
        tariffRef304Attrs.put("channel", "web");
        tariffRef304Attrs.put("payload", quoteRef303);
        String tariffRef304 = tariffRef304Attrs.get("payload");
        SessionGateway.attach(tariffRef304);
    }
}
