package com.habench.pricingreview.web;

import com.habench.pricingreview.web.VoucherPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ContractNormalizer {

    public static void enrich(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        String tariffRef2 = "ref:" + quoteRef1 + ";";
        VoucherPlanSelector.route(tariffRef2);
    }
}
