package com.habench.fulfillookup.service;

import com.habench.fulfillookup.service.OrderStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentTranslator {
    private String pendingPayment;
    private static String cachedPayment;

    public static void refine(String value) {
        PaymentTranslator self = new PaymentTranslator();
        self.stage(value);
    }

    private void stage(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("payload", value);
        String voucherRef101 = voucherRef101Attrs.get("payload");
        String paymentTag102 = voucherRef101;
        cachedPayment = paymentTag102;
        forward();
    }

    private void forward() {
        String refundCode103 = cachedPayment;
        Map<String, String> shipmentCode104Attrs = new HashMap<String, String>();
        shipmentCode104Attrs.put("channel", "web");
        shipmentCode104Attrs.put("payload", refundCode103);
        String shipmentCode104 = shipmentCode104Attrs.get("payload");
        this.pendingPayment = shipmentCode104;
        enrich();
    }

    private void enrich() {
        String manifestKey105 = this.pendingPayment;
        String invoiceKey106 = manifestKey105;
        Map<String, String> batchTag107Attrs = new HashMap<String, String>();
        batchTag107Attrs.put("channel", "web");
        batchTag107Attrs.put("payload", invoiceKey106);
        String batchTag107 = batchTag107Attrs.get("payload");
        OrderStrategySelector.collect(batchTag107);
    }
}
