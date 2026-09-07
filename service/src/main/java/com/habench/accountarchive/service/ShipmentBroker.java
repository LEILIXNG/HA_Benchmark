package com.habench.accountarchive.service;

import com.habench.accountarchive.service.BatchService;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBroker {
    private static String cachedTariff;

    public static void route(String value) {
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("payload", value);
        String manifestKey101 = manifestKey101Attrs.get("payload");
        cachedTariff = manifestKey101;
        compose();
    }

    private static void compose() {
        String invoiceKey102 = cachedTariff;
        String batchTag103 = invoiceKey102;
        Map<String, String> orderRef104Attrs = new HashMap<String, String>();
        orderRef104Attrs.put("channel", "web");
        orderRef104Attrs.put("payload", batchTag103);
        String orderRef104 = orderRef104Attrs.get("payload");
        cachedTariff = orderRef104;
        attach();
    }

    private static void attach() {
        String quoteRef105 = cachedTariff;
        Map<String, String> tariffRef106Attrs = new HashMap<String, String>();
        tariffRef106Attrs.put("channel", "web");
        tariffRef106Attrs.put("payload", quoteRef105);
        String tariffRef106 = tariffRef106Attrs.get("payload");
        BatchService.normalize(tariffRef106);
    }
}
