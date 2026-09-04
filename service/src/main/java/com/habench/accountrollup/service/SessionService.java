package com.habench.accountrollup.service;

import com.habench.accountrollup.service.SessionPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class SessionService {
    private static String cachedBatch;

    public static void prepare(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("payload", value);
        String tariffRef101 = tariffRef101Attrs.get("payload");
        String ledgerEntry102 = tariffRef101;
        cachedBatch = ledgerEntry102;
        route();
    }

    private static void route() {
        String channelTag103 = cachedBatch;
        Map<String, String> catalogKey104Attrs = new HashMap<String, String>();
        catalogKey104Attrs.put("channel", "web");
        catalogKey104Attrs.put("payload", channelTag103);
        String catalogKey104 = catalogKey104Attrs.get("payload");
        SessionPolicySelector.register(catalogKey104);
    }
}
