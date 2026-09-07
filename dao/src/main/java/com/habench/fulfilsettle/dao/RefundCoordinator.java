package com.habench.fulfilsettle.dao;

import com.habench.fulfilsettle.dao.InvoiceScreen;
import java.util.HashMap;
import java.util.Map;

public final class RefundCoordinator {

    public static void forward(String value) {
        String invoiceKey301 = value;
        Map<String, String> batchTag302Attrs = new HashMap<String, String>();
        batchTag302Attrs.put("channel", "web");
        batchTag302Attrs.put("payload", invoiceKey301);
        String batchTag302 = batchTag302Attrs.get("payload");
        InvoiceScreen.resolve(batchTag302);
    }
}
