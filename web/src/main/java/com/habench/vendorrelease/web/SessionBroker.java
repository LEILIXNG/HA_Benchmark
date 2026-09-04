package com.habench.vendorrelease.web;

import com.habench.vendorrelease.web.ShipmentStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class SessionBroker {
    private static String cachedRefund;

    public static void collect(String value) {
        String orderRef101 = "ref:" + value + ";";
        String quoteRef102 = "ref:" + orderRef101 + ";";
        cachedRefund = quoteRef102;
        prepare();
    }

    private static void prepare() {
        String tariffRef103 = cachedRefund;
        String ledgerEntry104 = "ref:" + tariffRef103 + ";";
        String channelTag105 = ledgerEntry104;
        cachedRefund = channelTag105;
        translate();
    }

    private static void translate() {
        String catalogKey106 = cachedRefund;
        Map<String, String> receiptKey107Attrs = new HashMap<String, String>();
        receiptKey107Attrs.put("channel", "web");
        receiptKey107Attrs.put("payload", catalogKey106);
        String receiptKey107 = receiptKey107Attrs.get("payload");
        Map<String, String> accountRef108Attrs = new HashMap<String, String>();
        accountRef108Attrs.put("channel", "web");
        accountRef108Attrs.put("payload", receiptKey107);
        String accountRef108 = accountRef108Attrs.get("payload");
        ShipmentStrategySelector.attach(accountRef108);
    }
}
