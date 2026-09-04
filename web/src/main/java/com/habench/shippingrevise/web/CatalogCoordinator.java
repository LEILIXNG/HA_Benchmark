package com.habench.shippingrevise.web;

import com.habench.shippingrevise.service.OrderCollector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCoordinator {
    private String pendingQuote;

    public static void assemble(String value) {
        CatalogCoordinator self = new CatalogCoordinator();
        self.prepare(value);
    }

    private void prepare(String value) {
        String accountRef1 = value;
        this.pendingQuote = accountRef1;
        enrich();
    }

    private void enrich() {
        String voucherRef2 = this.pendingQuote;
        Map<String, String> paymentTag3Attrs = new HashMap<String, String>();
        paymentTag3Attrs.put("channel", "web");
        paymentTag3Attrs.put("payload", voucherRef2);
        String paymentTag3 = paymentTag3Attrs.get("payload");
        String refundCode4 = paymentTag3;
        OrderCollector.prepare(refundCode4);
    }
}
