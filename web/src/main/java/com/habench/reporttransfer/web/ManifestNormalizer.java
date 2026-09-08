package com.habench.reporttransfer.web;

import com.habench.reporttransfer.web.SessionRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestNormalizer {

    public static void submit(String value) {
        String batchTag1 = "ref:" + value + ";";
        Map<String, String> orderRef2Attrs = new HashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("payload", batchTag1);
        String orderRef2 = orderRef2Attrs.get("payload");
        SessionRuleSelector.forward(orderRef2);
    }
}
