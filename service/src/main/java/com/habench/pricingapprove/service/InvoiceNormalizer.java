package com.habench.pricingapprove.service;

import com.habench.pricingapprove.service.InvoiceService;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceNormalizer {

    public static void publish(String value) {
        Map<String, String> quoteRef101Attrs = new HashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("payload", value);
        String quoteRef101 = quoteRef101Attrs.get("payload");
        Map<String, String> tariffRef102Attrs = new HashMap<String, String>();
        tariffRef102Attrs.put("channel", "web");
        tariffRef102Attrs.put("payload", quoteRef101);
        String tariffRef102 = tariffRef102Attrs.get("payload");
        InvoiceService.translate(tariffRef102);
    }
}
