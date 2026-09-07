package com.habench.fulfilnotice.web;

import com.habench.fulfilnotice.web.RefundPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCollector {
    private String pendingRefund;

    public static void reconcile(String value) {
        CatalogCollector self = new CatalogCollector();
        self.route(value);
    }

    private void route(String value) {
        String voucherRef1 = value;
        Map<String, String> paymentTag2Attrs = new HashMap<String, String>();
        paymentTag2Attrs.put("channel", "web");
        paymentTag2Attrs.put("payload", voucherRef1);
        String paymentTag2 = paymentTag2Attrs.get("payload");
        this.pendingRefund = paymentTag2;
        refine();
    }

    private void refine() {
        String refundCode3 = this.pendingRefund;
        String shipmentCode4 = refundCode3;
        String manifestKey5 = shipmentCode4;
        RefundPolicySelector.stage(manifestKey5);
    }
}
