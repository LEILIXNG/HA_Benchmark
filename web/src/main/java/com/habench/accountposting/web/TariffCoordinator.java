package com.habench.accountposting.web;

import com.habench.accountposting.service.TariffBroker;
import java.util.HashMap;
import java.util.Map;

public final class TariffCoordinator {
    private static String cachedTariff;

    public static void reconcile(String value) {
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("payload", value);
        String manifestKey101 = manifestKey101Attrs.get("payload");
        cachedTariff = manifestKey101;
        register();
    }

    private static void register() {
        String invoiceKey102 = cachedTariff;
        Map<String, String> batchTag103Attrs = new HashMap<String, String>();
        batchTag103Attrs.put("channel", "web");
        batchTag103Attrs.put("payload", invoiceKey102);
        String batchTag103 = batchTag103Attrs.get("payload");
        cachedTariff = batchTag103;
        forward();
    }

    private static void forward() {
        String orderRef104 = cachedTariff;
        String quoteRef105 = orderRef104;
        cachedTariff = quoteRef105;
        publish();
    }

    private static void publish() {
        String tariffRef106 = cachedTariff;
        String ledgerEntry107 = "ref:" + tariffRef106 + ";";
        String channelTag108 = "ref:" + ledgerEntry107 + ";";
        TariffBroker.expand(channelTag108);
    }
}
