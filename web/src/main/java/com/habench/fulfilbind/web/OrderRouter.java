package com.habench.fulfilbind.web;

import com.habench.fulfilbind.service.CatalogRegistry;
import java.util.HashMap;
import java.util.Map;

public final class OrderRouter {
    private String pendingCatalog;

    public static void forward(String value) {
        OrderRouter self = new OrderRouter();
        self.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        this.pendingCatalog = refundCode101;
        enrich();
    }

    private void enrich() {
        String shipmentCode102 = this.pendingCatalog;
        String manifestKey103 = shipmentCode102;
        CatalogRegistry.compose(manifestKey103);
    }
}
