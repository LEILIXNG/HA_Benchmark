package com.habench.ordersubmit.service;

import com.habench.ordersubmit.dao.InvoiceRouter;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptResolver {

    public static void register(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        String quoteRef102 = "ref:" + orderRef101 + ";";
        InvoiceRouter.translate(quoteRef102);
    }
}
