package com.habench.orderrollup.service;

import com.habench.orderrollup.service.BundleEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceAssembler {
    private String pendingBundle;

    public static void forward(String value) {
        InvoiceAssembler self = new InvoiceAssembler();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String accountRef101 = value;
        this.pendingBundle = accountRef101;
        stage();
    }

    private void stage() {
        String voucherRef102 = this.pendingBundle;
        Map<String, String> paymentTag103Attrs = new HashMap<String, String>();
        paymentTag103Attrs.put("channel", "web");
        paymentTag103Attrs.put("payload", voucherRef102);
        String paymentTag103 = paymentTag103Attrs.get("payload");
        BundleEvaluator.reconcile(paymentTag103);
    }
}
