package com.habench.reportreview.web;

import com.habench.reportreview.web.BatchPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleBroker {

    public static void dispatch(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        BatchPolicySelector.translate(accountRef1);
    }
}
