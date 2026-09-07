package com.habench.vendorassign.service;

import com.habench.vendorassign.service.SessionLoader;
import java.util.HashMap;
import java.util.Map;

public final class QuoteComposer {
    private String pendingSession;
    private static String cachedSession;

    public static void compose(String value) {
        QuoteComposer self = new QuoteComposer();
        self.collect(value);
    }

    private void collect(String value) {
        String catalogKey101 = "ref:" + value + ";";
        this.pendingSession = catalogKey101;
        route();
    }

    private void route() {
        String receiptKey102 = this.pendingSession;
        String accountRef103 = receiptKey102;
        this.pendingSession = accountRef103;
        normalize();
    }

    private void normalize() {
        String voucherRef104 = this.pendingSession;
        Map<String, String> paymentTag105Attrs = new HashMap<String, String>();
        paymentTag105Attrs.put("channel", "web");
        paymentTag105Attrs.put("payload", voucherRef104);
        String paymentTag105 = paymentTag105Attrs.get("payload");
        String refundCode106 = "ref:" + paymentTag105 + ";";
        cachedSession = refundCode106;
        stage();
    }

    private void stage() {
        String shipmentCode107 = cachedSession;
        String manifestKey108 = shipmentCode107;
        SessionLoader.reconcile(manifestKey108);
    }
}
