package com.habench.paymentquote.web;

import com.habench.paymentquote.service.PaymentAssembler;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceNormalizer {

    public static void submit(String value) {
        String orderRef201 = value;
        Map<String, String> quoteRef202Attrs = new HashMap<String, String>();
        quoteRef202Attrs.put("channel", "web");
        quoteRef202Attrs.put("payload", orderRef201);
        String quoteRef202 = quoteRef202Attrs.get("payload");
        PaymentAssembler.merge(quoteRef202);
    }
}
