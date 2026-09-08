package com.habench.inventoryledger.dao;

import com.habench.inventoryledger.dao.TariffPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelBroker {

    public static void enrich(String value) {
        Map<String, String> paymentTag301Attrs = new HashMap<String, String>();
        paymentTag301Attrs.put("channel", "web");
        paymentTag301Attrs.put("payload", value);
        String paymentTag301 = paymentTag301Attrs.get("payload");
        String refundCode302 = "ref:" + paymentTag301 + ";";
        TariffPlanSelector.translate(refundCode302);
    }
}
