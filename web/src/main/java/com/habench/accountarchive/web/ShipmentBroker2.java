package com.habench.accountarchive.web;

import com.habench.accountarchive.service.ShipmentBroker;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBroker2 {
    private static String cachedTariff;

    public static void expand(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        cachedTariff = tariffRef1;
        reconcile();
    }

    private static void reconcile() {
        String ledgerEntry2 = cachedTariff;
        String channelTag3 = ledgerEntry2;
        ShipmentBroker.route(channelTag3);
    }
}
