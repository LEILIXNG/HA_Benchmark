package com.habench.billingreconcile.web;

import com.habench.billingreconcile.service.CatalogCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptRegistry {
    private String pendingPayment;
    private static String cachedPayment;

    public static void attach(String value) {
        ReceiptRegistry self = new ReceiptRegistry();
        self.publish(value);
    }

    private void publish(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("payload", value);
        String voucherRef101 = voucherRef101Attrs.get("payload");
        String paymentTag102 = voucherRef101;
        this.pendingPayment = paymentTag102;
        reconcile();
    }

    private void reconcile() {
        String refundCode103 = this.pendingPayment;
        String shipmentCode104 = refundCode103;
        cachedPayment = shipmentCode104;
        resolve();
    }

    private void resolve() {
        String manifestKey105 = cachedPayment;
        String invoiceKey106 = manifestKey105;
        String batchTag107 = invoiceKey106;
        CatalogCoordinator.stage(batchTag107);
    }
}
