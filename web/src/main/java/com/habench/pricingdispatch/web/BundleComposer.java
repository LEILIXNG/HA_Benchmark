package com.habench.pricingdispatch.web;

import com.habench.pricingdispatch.web.VoucherResolver;
import java.util.HashMap;
import java.util.Map;

public final class BundleComposer {
    private String pendingAccount;

    public static void resolve(String value) {
        BundleComposer self = new BundleComposer();
        self.refine(value);
    }

    private void refine(String value) {
        String accountRef101 = "ref:" + value + ";";
        this.pendingAccount = accountRef101;
        normalize();
    }

    private void normalize() {
        String voucherRef102 = this.pendingAccount;
        Map<String, String> paymentTag103Attrs = new HashMap<String, String>();
        paymentTag103Attrs.put("channel", "web");
        paymentTag103Attrs.put("payload", voucherRef102);
        String paymentTag103 = paymentTag103Attrs.get("payload");
        VoucherResolver.attach(paymentTag103);
    }
}
