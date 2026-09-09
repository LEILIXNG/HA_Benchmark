package com.habench.billingassign.web;

import com.habench.billingassign.web.QuoteFetcher;
import java.util.HashMap;
import java.util.Map;

public final class ContractAdapter {

    public static void compose(String value) {
        Map<String, String> quoteRef101Attrs = new HashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("payload", value);
        String quoteRef101 = quoteRef101Attrs.get("payload");
        QuoteFetcher.route(quoteRef101);
    }
}
