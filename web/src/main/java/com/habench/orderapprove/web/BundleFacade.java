package com.habench.orderapprove.web;

import com.habench.orderapprove.web.ShipmentRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleFacade {

    public static void translate(String value) {
        String quoteRef1 = value;
        Map<String, String> tariffRef2Attrs = new HashMap<String, String>();
        tariffRef2Attrs.put("channel", "web");
        tariffRef2Attrs.put("payload", quoteRef1);
        String tariffRef2 = tariffRef2Attrs.get("payload");
        ShipmentRuleSelector.stage(tariffRef2);
    }
}
