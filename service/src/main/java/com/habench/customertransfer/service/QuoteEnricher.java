package com.habench.customertransfer.service;

import com.habench.customertransfer.service.BundleRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteEnricher {

    public static void assemble(String value) {
        Map<String, String> tariffRef301Attrs = new HashMap<String, String>();
        tariffRef301Attrs.put("channel", "web");
        tariffRef301Attrs.put("payload", value);
        String tariffRef301 = tariffRef301Attrs.get("payload");
        BundleRuleSelector.stage(tariffRef301);
    }
}
