package com.habench.orderissue.dao;

import com.habench.orderissue.dao.ChannelRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleBroker {
    private static String cachedLedger;

    public static void resolve(String value) {
        String paymentTag301 = "ref:" + value + ";";
        Map<String, String> refundCode302Attrs = new HashMap<String, String>();
        refundCode302Attrs.put("channel", "web");
        refundCode302Attrs.put("payload", paymentTag301);
        String refundCode302 = refundCode302Attrs.get("payload");
        cachedLedger = refundCode302;
        compose();
    }

    private static void compose() {
        String shipmentCode303 = cachedLedger;
        String manifestKey304 = "ref:" + shipmentCode303 + ";";
        ChannelRuleSelector.merge(manifestKey304);
    }
}
