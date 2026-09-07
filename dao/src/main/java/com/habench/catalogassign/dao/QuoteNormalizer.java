package com.habench.catalogassign.dao;

import com.habench.catalogassign.dao.InvoiceScreen;
import java.util.HashMap;
import java.util.Map;

public final class QuoteNormalizer {

    public static void assemble(String value) {
        Map<String, String> paymentTag501Attrs = new HashMap<String, String>();
        paymentTag501Attrs.put("channel", "web");
        paymentTag501Attrs.put("payload", value);
        String paymentTag501 = paymentTag501Attrs.get("payload");
        InvoiceScreen.forward(paymentTag501);
    }
}
