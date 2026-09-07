package com.habench.billingrollup.service;

import com.habench.billingrollup.service.LedgerPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffBroker {
    private static String cachedOrder;

    public static void dispatch(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("payload", value);
        String tariffRef101 = tariffRef101Attrs.get("payload");
        String ledgerEntry102 = tariffRef101;
        cachedOrder = ledgerEntry102;
        stage();
    }

    private static void stage() {
        String channelTag103 = cachedOrder;
        Map<String, String> catalogKey104Attrs = new HashMap<String, String>();
        catalogKey104Attrs.put("channel", "web");
        catalogKey104Attrs.put("payload", channelTag103);
        String catalogKey104 = catalogKey104Attrs.get("payload");
        LedgerPolicySelector.stage(catalogKey104);
    }
}
