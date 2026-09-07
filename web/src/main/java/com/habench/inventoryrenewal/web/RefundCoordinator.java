package com.habench.inventoryrenewal.web;

import com.habench.inventoryrenewal.web.LedgerLoader;
import java.util.HashMap;
import java.util.Map;

public final class RefundCoordinator {
    private String pendingLedger;

    public static void expand(String value) {
        RefundCoordinator self = new RefundCoordinator();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> manifestKey201Attrs = new HashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("payload", value);
        String manifestKey201 = manifestKey201Attrs.get("payload");
        this.pendingLedger = manifestKey201;
        compose();
    }

    private void compose() {
        String invoiceKey202 = this.pendingLedger;
        String batchTag203 = "ref:" + invoiceKey202 + ";";
        Map<String, String> orderRef204Attrs = new HashMap<String, String>();
        orderRef204Attrs.put("channel", "web");
        orderRef204Attrs.put("payload", batchTag203);
        String orderRef204 = orderRef204Attrs.get("payload");
        LedgerLoader.route(orderRef204);
    }
}
