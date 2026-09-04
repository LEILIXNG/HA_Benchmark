package com.habench.reportsplit.web;

import com.habench.reportsplit.service.QuoteEnricher;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAssembler {
    private static String cachedVoucher;

    public static void compose(String value) {
        String manifestKey101 = "ref:" + value + ";";
        String invoiceKey102 = "ref:" + manifestKey101 + ";";
        cachedVoucher = invoiceKey102;
        submit();
    }

    private static void submit() {
        String batchTag103 = cachedVoucher;
        String orderRef104 = batchTag103;
        Map<String, String> quoteRef105Attrs = new HashMap<String, String>();
        quoteRef105Attrs.put("channel", "web");
        quoteRef105Attrs.put("payload", orderRef104);
        String quoteRef105 = quoteRef105Attrs.get("payload");
        QuoteEnricher.expand(quoteRef105);
    }
}
