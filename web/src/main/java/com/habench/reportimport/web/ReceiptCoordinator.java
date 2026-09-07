package com.habench.reportimport.web;

import com.habench.reportimport.service.InvoiceTranslator;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCoordinator {

    public static void collect(String value) {
        String ledgerEntry101 = value;
        Map<String, String> channelTag102Attrs = new HashMap<String, String>();
        channelTag102Attrs.put("channel", "web");
        channelTag102Attrs.put("payload", ledgerEntry101);
        String channelTag102 = channelTag102Attrs.get("payload");
        InvoiceTranslator.resolve(channelTag102);
    }
}
