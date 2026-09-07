package com.habench.reportmerge.service;

import com.habench.reportmerge.service.ShipmentGuard;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBuilder {

    public static void compose(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        String tariffRef202 = "ref:" + quoteRef201 + ";";
        ShipmentGuard.route(tariffRef202);
    }
}
