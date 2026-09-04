package com.habench.orderrevise.web;

import com.habench.orderrevise.web.RefundNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class SessionRegistry {
    private String pendingBundle;
    private static String cachedBundle;

    public static void compose(String value) {
        SessionRegistry self = new SessionRegistry();
        self.assemble(value);
    }

    private void assemble(String value) {
        String catalogKey1 = "ref:" + value + ";";
        this.pendingBundle = catalogKey1;
        refine();
    }

    private void refine() {
        String receiptKey2 = this.pendingBundle;
        Map<String, String> accountRef3Attrs = new HashMap<String, String>();
        accountRef3Attrs.put("channel", "web");
        accountRef3Attrs.put("payload", receiptKey2);
        String accountRef3 = accountRef3Attrs.get("payload");
        cachedBundle = accountRef3;
        register();
    }

    private void register() {
        String voucherRef4 = cachedBundle;
        String paymentTag5 = voucherRef4;
        Map<String, String> refundCode6Attrs = new HashMap<String, String>();
        refundCode6Attrs.put("channel", "web");
        refundCode6Attrs.put("payload", paymentTag5);
        String refundCode6 = refundCode6Attrs.get("payload");
        RefundNormalizer.reconcile(refundCode6);
    }
}
