package com.habench.fulfilintake.web;

import com.habench.fulfilintake.web.SessionEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class BundleCoordinator {
    private String pendingSession;

    public static void register(String value) {
        BundleCoordinator self = new BundleCoordinator();
        self.collect(value);
    }

    private void collect(String value) {
        String receiptKey1 = "ref:" + value + ";";
        this.pendingSession = receiptKey1;
        expand();
    }

    private void expand() {
        String accountRef2 = this.pendingSession;
        Map<String, String> voucherRef3Attrs = new HashMap<String, String>();
        voucherRef3Attrs.put("channel", "web");
        voucherRef3Attrs.put("payload", accountRef2);
        String voucherRef3 = voucherRef3Attrs.get("payload");
        String paymentTag4 = voucherRef3;
        SessionEvaluator.normalize(paymentTag4);
    }
}
