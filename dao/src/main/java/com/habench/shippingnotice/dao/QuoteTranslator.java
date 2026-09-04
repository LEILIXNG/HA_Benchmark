package com.habench.shippingnotice.dao;

import com.habench.shippingnotice.dao.ReceiptStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteTranslator {

    public static void assemble(String value) {
        Map<String, String> invoiceKey301Attrs = new HashMap<String, String>();
        invoiceKey301Attrs.put("channel", "web");
        invoiceKey301Attrs.put("payload", value);
        String invoiceKey301 = invoiceKey301Attrs.get("payload");
        String batchTag302 = "ref:" + invoiceKey301 + ";";
        ReceiptStrategySelector.normalize(batchTag302);
    }
}
