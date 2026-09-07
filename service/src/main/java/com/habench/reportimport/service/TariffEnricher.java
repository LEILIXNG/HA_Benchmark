package com.habench.reportimport.service;

import com.habench.reportimport.service.TariffPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffEnricher {

    public static void resolve(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("payload", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("payload");
        String channelTag102 = "ref:" + ledgerEntry101 + ";";
        TariffPlanSelector.prepare(channelTag102);
    }
}
