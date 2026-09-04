package com.habench.reportapprove.web;

import com.habench.reportapprove.web.InvoiceFacade;
import java.util.HashMap;
import java.util.Map;

public final class BundleBroker {

    public static void route(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        InvoiceFacade.dispatch(batchTag1);
    }
}
