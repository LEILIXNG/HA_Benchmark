package com.habench.orderdigest.service;

import com.habench.orderdigest.service.RefundEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class VoucherBroker {
    private String pendingRefund;
    private static String cachedRefund;

    public static void dispatch(String value) {
        VoucherBroker self = new VoucherBroker();
        self.enrich(value);
    }

    private void enrich(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        cachedRefund = ledgerEntry101;
        register();
    }

    private void register() {
        String channelTag102 = cachedRefund;
        String catalogKey103 = channelTag102;
        Map<String, String> receiptKey104Attrs = new HashMap<String, String>();
        receiptKey104Attrs.put("channel", "web");
        receiptKey104Attrs.put("payload", catalogKey103);
        String receiptKey104 = receiptKey104Attrs.get("payload");
        cachedRefund = receiptKey104;
        normalize();
    }

    private void normalize() {
        String accountRef105 = cachedRefund;
        String voucherRef106 = accountRef105;
        cachedRefund = voucherRef106;
        translate();
    }

    private void translate() {
        String paymentTag107 = cachedRefund;
        String refundCode108 = paymentTag107;
        String shipmentCode109 = refundCode108;
        this.pendingRefund = shipmentCode109;
        compose();
    }

    private void compose() {
        String manifestKey110 = this.pendingRefund;
        String invoiceKey111 = "ref:" + manifestKey110 + ";";
        this.pendingRefund = invoiceKey111;
        assemble();
    }

    private void assemble() {
        String batchTag112 = this.pendingRefund;
        String orderRef113 = "ref:" + batchTag112 + ";";
        RefundEvaluator.stage(orderRef113);
    }
}
