package com.habench.customerreview.web;

import com.habench.customerreview.web.AccountAssembler;
import java.util.HashMap;
import java.util.Map;

public final class LedgerResolver {

    public static void route(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("payload", value);
        String batchTag101 = batchTag101Attrs.get("payload");
        AccountAssembler.route(batchTag101);
    }
}
