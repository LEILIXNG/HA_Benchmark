package com.habench.vendordigest.service;

import com.habench.vendordigest.service.TariffEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class OrderBuilder {

    public static void route(String value) {
        Map<String, String> tariffRef301Attrs = new HashMap<String, String>();
        tariffRef301Attrs.put("channel", "web");
        tariffRef301Attrs.put("payload", value);
        String tariffRef301 = tariffRef301Attrs.get("payload");
        TariffEvaluator.prepare(tariffRef301);
    }
}
