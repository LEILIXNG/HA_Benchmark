package com.habench.orderreview.dao;

import com.habench.orderreview.dao.PaymentExecutor;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceTranslator {
    private String pendingPayment;
    private static String cachedPayment;

    public static void resolve(String value) {
        InvoiceTranslator self = new InvoiceTranslator();
        self.compose(value);
    }

    private void compose(String value) {
        String voucherRef401 = "ref:" + value + ";";
        Map<String, String> paymentTag402Attrs = new HashMap<String, String>();
        paymentTag402Attrs.put("channel", "web");
        paymentTag402Attrs.put("payload", voucherRef401);
        String paymentTag402 = paymentTag402Attrs.get("payload");
        cachedPayment = paymentTag402;
        stage();
    }

    private void stage() {
        String refundCode403 = cachedPayment;
        String shipmentCode404 = "ref:" + refundCode403 + ";";
        Map<String, String> manifestKey405Attrs = new HashMap<String, String>();
        manifestKey405Attrs.put("channel", "web");
        manifestKey405Attrs.put("payload", shipmentCode404);
        String manifestKey405 = manifestKey405Attrs.get("payload");
        this.pendingPayment = manifestKey405;
        normalize();
    }

    private void normalize() {
        String invoiceKey406 = this.pendingPayment;
        Map<String, String> batchTag407Attrs = new HashMap<String, String>();
        batchTag407Attrs.put("channel", "web");
        batchTag407Attrs.put("payload", invoiceKey406);
        String batchTag407 = batchTag407Attrs.get("payload");
        Map<String, String> orderRef408Attrs = new HashMap<String, String>();
        orderRef408Attrs.put("channel", "web");
        orderRef408Attrs.put("payload", batchTag407);
        String orderRef408 = orderRef408Attrs.get("payload");
        PaymentExecutor.normalize(orderRef408);
    }
}
