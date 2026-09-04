package com.habench.inventorybind.service;

import com.habench.inventorybind.service.PaymentRepository;
import java.util.HashMap;
import java.util.Map;

public final class ManifestTranslator {
    private String pendingPayment;

    public static void refine(String value) {
        ManifestTranslator self = new ManifestTranslator();
        self.route(value);
    }

    private void route(String value) {
        String paymentTag101 = value;
        String refundCode102 = paymentTag101;
        this.pendingPayment = refundCode102;
        prepare();
    }

    private void prepare() {
        String shipmentCode103 = this.pendingPayment;
        Map<String, String> manifestKey104Attrs = new HashMap<String, String>();
        manifestKey104Attrs.put("channel", "web");
        manifestKey104Attrs.put("payload", shipmentCode103);
        String manifestKey104 = manifestKey104Attrs.get("payload");
        String invoiceKey105 = "ref:" + manifestKey104 + ";";
        PaymentRepository.normalize(invoiceKey105);
    }
}
