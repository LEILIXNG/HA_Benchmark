package com.habench.paymentdraft.service;

import com.habench.paymentdraft.service.ShipmentRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceFacade {

    public static void enrich(String value) {
        String quoteRef101 = "ref:" + value + ";";
        Map<String, String> tariffRef102Attrs = new HashMap<String, String>();
        tariffRef102Attrs.put("channel", "web");
        tariffRef102Attrs.put("payload", quoteRef101);
        String tariffRef102 = tariffRef102Attrs.get("payload");
        ShipmentRuleSelector.merge(tariffRef102);
    }
}
