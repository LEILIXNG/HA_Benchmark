package com.habench.orderapprove.web;

import com.habench.orderapprove.web.OrderScreen;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentRouter {
    private String pendingCatalog;

    public static void attach(String value) {
        ShipmentRouter self = new ShipmentRouter();
        self.assemble(value);
    }

    private void assemble(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        this.pendingCatalog = invoiceKey1;
        refine();
    }

    private void refine() {
        String batchTag2 = this.pendingCatalog;
        Map<String, String> orderRef3Attrs = new HashMap<String, String>();
        orderRef3Attrs.put("channel", "web");
        orderRef3Attrs.put("payload", batchTag2);
        String orderRef3 = orderRef3Attrs.get("payload");
        String quoteRef4 = orderRef3;
        OrderScreen.normalize(quoteRef4);
    }
}
