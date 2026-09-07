package com.habench.orderhold.service;

import com.habench.orderhold.dao.ShipmentService;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceCollector {
    private String pendingBundle;

    public static void collect(String value) {
        InvoiceCollector self = new InvoiceCollector();
        self.route(value);
    }

    private void route(String value) {
        Map<String, String> channelTag101Attrs = new HashMap<String, String>();
        channelTag101Attrs.put("channel", "web");
        channelTag101Attrs.put("payload", value);
        String channelTag101 = channelTag101Attrs.get("payload");
        String catalogKey102 = channelTag101;
        this.pendingBundle = catalogKey102;
        compose();
    }

    private void compose() {
        String receiptKey103 = this.pendingBundle;
        String accountRef104 = "ref:" + receiptKey103 + ";";
        ShipmentService.route(accountRef104);
    }
}
