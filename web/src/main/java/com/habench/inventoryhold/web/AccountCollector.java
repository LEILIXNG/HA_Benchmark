package com.habench.inventoryhold.web;

import com.habench.inventoryhold.web.BundleLoader;
import java.util.HashMap;
import java.util.Map;

public final class AccountCollector {
    private String pendingBundle;

    public static void reconcile(String value) {
        AccountCollector self = new AccountCollector();
        self.refine(value);
    }

    private void refine(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("payload", value);
        String paymentTag1 = paymentTag1Attrs.get("payload");
        Map<String, String> refundCode2Attrs = new HashMap<String, String>();
        refundCode2Attrs.put("channel", "web");
        refundCode2Attrs.put("payload", paymentTag1);
        String refundCode2 = refundCode2Attrs.get("payload");
        this.pendingBundle = refundCode2;
        attach();
    }

    private void attach() {
        String shipmentCode3 = this.pendingBundle;
        String manifestKey4 = shipmentCode3;
        String invoiceKey5 = manifestKey4;
        BundleLoader.stage(invoiceKey5);
    }
}
