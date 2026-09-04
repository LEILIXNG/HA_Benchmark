package com.habench.orderrollup.web;

import com.habench.orderrollup.service.InvoiceResolver;
import java.util.HashMap;
import java.util.Map;

public final class ChannelRouter {

    public static void merge(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        Map<String, String> ledgerEntry2Attrs = new HashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("payload", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get("payload");
        InvoiceResolver.route(ledgerEntry2);
    }
}
