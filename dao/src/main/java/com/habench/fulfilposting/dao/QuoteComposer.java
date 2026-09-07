package com.habench.fulfilposting.dao;

import com.habench.fulfilposting.dao.ReceiptExecutor;
import java.util.HashMap;
import java.util.Map;

public final class QuoteComposer {

    public static void prepare(String value) {
        String manifestKey501 = "ref:" + value + ";";
        Map<String, String> invoiceKey502Attrs = new HashMap<String, String>();
        invoiceKey502Attrs.put("channel", "web");
        invoiceKey502Attrs.put("payload", manifestKey501);
        String invoiceKey502 = invoiceKey502Attrs.get("payload");
        ReceiptExecutor.register(invoiceKey502);
    }
}
