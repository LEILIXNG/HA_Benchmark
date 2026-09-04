package com.habench.reportreview.web;

import com.habench.reportreview.web.SessionRegistry;
import java.util.HashMap;
import java.util.Map;

public final class QuoteCoordinator {

    public static void stage(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        SessionRegistry.translate(invoiceKey101);
    }
}
