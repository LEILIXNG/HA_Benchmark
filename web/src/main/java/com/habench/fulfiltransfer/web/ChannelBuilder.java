package com.habench.fulfiltransfer.web;

import com.habench.fulfiltransfer.service.VoucherAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ChannelBuilder {

    public static void publish(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        String batchTag2 = invoiceKey1;
        VoucherAdapter.reconcile(batchTag2);
    }
}
