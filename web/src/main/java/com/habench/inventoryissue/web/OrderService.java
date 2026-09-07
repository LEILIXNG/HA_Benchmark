package com.habench.inventoryissue.web;

import com.habench.inventoryissue.service.ChannelFacade;
import java.util.HashMap;
import java.util.Map;

public final class OrderService {

    public static void stage(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        ChannelFacade.reconcile(invoiceKey1);
    }
}
