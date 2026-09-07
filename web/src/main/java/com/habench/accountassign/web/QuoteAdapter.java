package com.habench.accountassign.web;

import com.habench.accountassign.service.SessionCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAdapter {
    private String pendingManifest;
    private static String cachedManifest;

    public static void compose(String value) {
        QuoteAdapter self = new QuoteAdapter();
        self.register(value);
    }

    private void register(String value) {
        String catalogKey1 = value;
        this.pendingManifest = catalogKey1;
        collect();
    }

    private void collect() {
        String receiptKey2 = this.pendingManifest;
        String accountRef3 = receiptKey2;
        String voucherRef4 = "ref:" + accountRef3 + ";";
        cachedManifest = voucherRef4;
        reconcile();
    }

    private void reconcile() {
        String paymentTag5 = cachedManifest;
        Map<String, String> refundCode6Attrs = new HashMap<String, String>();
        refundCode6Attrs.put("channel", "web");
        refundCode6Attrs.put("payload", paymentTag5);
        String refundCode6 = refundCode6Attrs.get("payload");
        cachedManifest = refundCode6;
        refine();
    }

    private void refine() {
        String shipmentCode7 = cachedManifest;
        Map<String, String> manifestKey8Attrs = new HashMap<String, String>();
        manifestKey8Attrs.put("channel", "web");
        manifestKey8Attrs.put("payload", shipmentCode7);
        String manifestKey8 = manifestKey8Attrs.get("payload");
        SessionCoordinator.submit(manifestKey8);
    }
}
