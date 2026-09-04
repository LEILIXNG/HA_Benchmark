package com.habench.billingmanifest.web;

import com.habench.billingmanifest.service.ReceiptEnricher;
import java.util.HashMap;
import java.util.Map;

public final class OrderResolver {
    private String pendingChannel;

    public static void expand(String value) {
        OrderResolver self = new OrderResolver();
        self.resolve(value);
    }

    private void resolve(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        String quoteRef2 = orderRef1;
        this.pendingChannel = quoteRef2;
        dispatch();
    }

    private void dispatch() {
        String tariffRef3 = this.pendingChannel;
        String ledgerEntry4 = tariffRef3;
        Map<String, String> channelTag5Attrs = new HashMap<String, String>();
        channelTag5Attrs.put("channel", "web");
        channelTag5Attrs.put("payload", ledgerEntry4);
        String channelTag5 = channelTag5Attrs.get("payload");
        ReceiptEnricher.resolve(channelTag5);
    }
}
