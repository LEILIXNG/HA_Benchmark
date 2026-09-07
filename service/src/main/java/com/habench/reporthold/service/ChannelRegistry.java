package com.habench.reporthold.service;

import com.habench.reporthold.service.SessionRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelRegistry {
    private static String cachedContract;

    public static void stage(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        cachedContract = refundCode101;
        normalize();
    }

    private static void normalize() {
        String shipmentCode102 = cachedContract;
        String manifestKey103 = shipmentCode102;
        SessionRuleSelector.compose(manifestKey103);
    }
}
