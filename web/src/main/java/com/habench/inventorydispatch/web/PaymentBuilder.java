package com.habench.inventorydispatch.web;

import com.habench.inventorydispatch.web.ReceiptAssembler;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBuilder {

    public static void register(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        String quoteRef2 = orderRef1;
        ReceiptAssembler.merge(quoteRef2);
    }
}
