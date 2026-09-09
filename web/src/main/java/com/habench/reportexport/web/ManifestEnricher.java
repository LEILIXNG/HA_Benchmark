package com.habench.reportexport.web;

import com.habench.reportexport.web.ManifestStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestEnricher {

    public static void reconcile(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        String voucherRef2 = "ref:" + accountRef1 + ";";
        ManifestStrategySelector.resolve(voucherRef2);
    }
}
