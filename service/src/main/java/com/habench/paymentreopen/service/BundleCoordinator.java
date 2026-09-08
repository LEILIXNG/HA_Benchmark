package com.habench.paymentreopen.service;

import com.habench.paymentreopen.dao.BundleBuilder;
import java.util.HashMap;
import java.util.Map;

public final class BundleCoordinator {
    private String pendingVoucher;

    public static void route(String value) {
        BundleCoordinator self = new BundleCoordinator();
        self.stage(value);
    }

    private void stage(String value) {
        String voucherRef101 = "ref:" + value + ";";
        this.pendingVoucher = voucherRef101;
        merge();
    }

    private void merge() {
        String paymentTag102 = this.pendingVoucher;
        Map<String, String> refundCode103Attrs = new HashMap<String, String>();
        refundCode103Attrs.put("channel", "web");
        refundCode103Attrs.put("payload", paymentTag102);
        String refundCode103 = refundCode103Attrs.get("payload");
        BundleBuilder.reconcile(refundCode103);
    }
}
