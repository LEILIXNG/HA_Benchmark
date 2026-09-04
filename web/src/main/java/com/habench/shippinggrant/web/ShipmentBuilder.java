package com.habench.shippinggrant.web;

import com.habench.shippinggrant.service.InvoiceResolver;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBuilder {
    private String pendingCatalog;

    public static void compose(String value) {
        ShipmentBuilder self = new ShipmentBuilder();
        self.attach(value);
    }

    private void attach(String value) {
        String channelTag1 = value;
        Map<String, String> catalogKey2Attrs = new HashMap<String, String>();
        catalogKey2Attrs.put("channel", "web");
        catalogKey2Attrs.put("payload", channelTag1);
        String catalogKey2 = catalogKey2Attrs.get("payload");
        this.pendingCatalog = catalogKey2;
        normalize();
    }

    private void normalize() {
        String receiptKey3 = this.pendingCatalog;
        String accountRef4 = receiptKey3;
        InvoiceResolver.normalize(accountRef4);
    }
}
