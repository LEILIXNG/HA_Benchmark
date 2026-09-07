package com.habench.paymentbatch.service;

import com.habench.paymentbatch.service.VoucherCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceCoordinator {
    private String pendingVoucher;

    public static void register(String value) {
        InvoiceCoordinator self = new InvoiceCoordinator();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> paymentTag301Attrs = new HashMap<String, String>();
        paymentTag301Attrs.put("channel", "web");
        paymentTag301Attrs.put("payload", value);
        String paymentTag301 = paymentTag301Attrs.get("payload");
        String refundCode302 = "ref:" + paymentTag301 + ";";
        this.pendingVoucher = refundCode302;
        expand();
    }

    private void expand() {
        String shipmentCode303 = this.pendingVoucher;
        Map<String, String> manifestKey304Attrs = new HashMap<String, String>();
        manifestKey304Attrs.put("channel", "web");
        manifestKey304Attrs.put("payload", shipmentCode303);
        String manifestKey304 = manifestKey304Attrs.get("payload");
        VoucherCoordinator.forward(manifestKey304);
    }
}
