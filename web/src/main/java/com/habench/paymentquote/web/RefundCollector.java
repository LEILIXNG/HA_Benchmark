package com.habench.paymentquote.web;

import com.habench.paymentquote.web.InvoiceNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class RefundCollector {
    private String pendingChannel;
    private static String cachedChannel;

    public static void attach(String value) {
        RefundCollector self = new RefundCollector();
        self.route(value);
    }

    private void route(String value) {
        String catalogKey101 = value;
        Map<String, String> receiptKey102Attrs = new HashMap<String, String>();
        receiptKey102Attrs.put("channel", "web");
        receiptKey102Attrs.put("payload", catalogKey101);
        String receiptKey102 = receiptKey102Attrs.get("payload");
        this.pendingChannel = receiptKey102;
        normalize();
    }

    private void normalize() {
        String accountRef103 = this.pendingChannel;
        Map<String, String> voucherRef104Attrs = new HashMap<String, String>();
        voucherRef104Attrs.put("channel", "web");
        voucherRef104Attrs.put("payload", accountRef103);
        String voucherRef104 = voucherRef104Attrs.get("payload");
        Map<String, String> paymentTag105Attrs = new HashMap<String, String>();
        paymentTag105Attrs.put("channel", "web");
        paymentTag105Attrs.put("payload", voucherRef104);
        String paymentTag105 = paymentTag105Attrs.get("payload");
        cachedChannel = paymentTag105;
        submit();
    }

    private void submit() {
        String refundCode106 = cachedChannel;
        Map<String, String> shipmentCode107Attrs = new HashMap<String, String>();
        shipmentCode107Attrs.put("channel", "web");
        shipmentCode107Attrs.put("payload", refundCode106);
        String shipmentCode107 = shipmentCode107Attrs.get("payload");
        InvoiceNormalizer.submit(shipmentCode107);
    }
}
