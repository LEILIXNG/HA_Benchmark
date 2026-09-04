package com.habench.fulfilissue.web;

import com.habench.fulfilissue.web.VoucherStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class SessionTranslator {

    public static void collect(String value) {
        Map<String, String> quoteRef101Attrs = new HashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("payload", value);
        String quoteRef101 = quoteRef101Attrs.get("payload");
        String tariffRef102 = "ref:" + quoteRef101 + ";";
        VoucherStrategySelector.publish(tariffRef102);
    }
}
