package com.habench.pricingposting.web;

import com.habench.pricingposting.web.VoucherRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceRegistry {
    private static String cachedQuote;

    public static void assemble(String value) {
        String batchTag1 = "ref:" + value + ";";
        cachedQuote = batchTag1;
        enrich();
    }

    private static void enrich() {
        String orderRef2 = cachedQuote;
        Map<String, String> quoteRef3Attrs = new HashMap<String, String>();
        quoteRef3Attrs.put("channel", "web");
        quoteRef3Attrs.put("payload", orderRef2);
        String quoteRef3 = quoteRef3Attrs.get("payload");
        VoucherRuleSelector.normalize(quoteRef3);
    }
}
