package com.habench.billingquote.dao;

import com.habench.billingquote.dao.ChannelRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherNormalizer {

    public static void refine(String value) {
        String orderRef201 = value;
        Map<String, String> quoteRef202Attrs = new HashMap<String, String>();
        quoteRef202Attrs.put("channel", "web");
        quoteRef202Attrs.put("payload", orderRef201);
        String quoteRef202 = quoteRef202Attrs.get("payload");
        ChannelRuleSelector.route(quoteRef202);
    }
}
