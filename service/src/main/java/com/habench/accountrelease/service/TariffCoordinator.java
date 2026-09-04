package com.habench.accountrelease.service;

import com.habench.accountrelease.service.ChannelPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffCoordinator {
    private static String cachedRefund;

    public static void assemble(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        cachedRefund = orderRef101;
        compose();
    }

    private static void compose() {
        String quoteRef102 = cachedRefund;
        Map<String, String> tariffRef103Attrs = new HashMap<String, String>();
        tariffRef103Attrs.put("channel", "web");
        tariffRef103Attrs.put("payload", quoteRef102);
        String tariffRef103 = tariffRef103Attrs.get("payload");
        String ledgerEntry104 = "ref:" + tariffRef103 + ";";
        ChannelPlanSelector.enrich(ledgerEntry104);
    }
}
