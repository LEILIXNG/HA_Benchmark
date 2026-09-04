package com.habench.paymentquote.web;

import com.habench.paymentquote.web.PaymentStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceNormalizer {

    public static void submit(String value) {
        String manifestKey101 = "ref:" + value + ";";
        Map<String, String> invoiceKey102Attrs = new HashMap<String, String>();
        invoiceKey102Attrs.put("channel", "web");
        invoiceKey102Attrs.put("payload", manifestKey101);
        String invoiceKey102 = invoiceKey102Attrs.get("payload");
        PaymentStrategySelector.merge(invoiceKey102);
    }
}
