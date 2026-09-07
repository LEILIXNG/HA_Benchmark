package com.habench.orderdigest.web;

import com.habench.orderdigest.service.RefundCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAssembler {
    private String pendingRefund;
    private static String cachedRefund;

    public static void resolve(String value) {
        QuoteAssembler self = new QuoteAssembler();
        self.refine(value);
    }

    private void refine(String value) {
        String voucherRef1 = value;
        String paymentTag2 = "ref:" + voucherRef1 + ";";
        this.pendingRefund = paymentTag2;
        assemble();
    }

    private void assemble() {
        String refundCode3 = this.pendingRefund;
        String shipmentCode4 = refundCode3;
        cachedRefund = shipmentCode4;
        register();
    }

    private void register() {
        String manifestKey5 = cachedRefund;
        String invoiceKey6 = manifestKey5;
        String batchTag7 = invoiceKey6;
        cachedRefund = batchTag7;
        expand();
    }

    private void expand() {
        String orderRef8 = cachedRefund;
        String quoteRef9 = "ref:" + orderRef8 + ";";
        Map<String, String> tariffRef10Attrs = new HashMap<String, String>();
        tariffRef10Attrs.put("channel", "web");
        tariffRef10Attrs.put("payload", quoteRef9);
        String tariffRef10 = tariffRef10Attrs.get("payload");
        this.pendingRefund = tariffRef10;
        enrich();
    }

    private void enrich() {
        String ledgerEntry11 = this.pendingRefund;
        String channelTag12 = "ref:" + ledgerEntry11 + ";";
        String catalogKey13 = channelTag12;
        this.pendingRefund = catalogKey13;
        compose();
    }

    private void compose() {
        String receiptKey14 = this.pendingRefund;
        String accountRef15 = receiptKey14;
        this.pendingRefund = accountRef15;
        forward();
    }

    private void forward() {
        String voucherRef16 = this.pendingRefund;
        String paymentTag17 = "ref:" + voucherRef16 + ";";
        Map<String, String> refundCode18Attrs = new HashMap<String, String>();
        refundCode18Attrs.put("channel", "web");
        refundCode18Attrs.put("payload", paymentTag17);
        String refundCode18 = refundCode18Attrs.get("payload");
        this.pendingRefund = refundCode18;
        translate();
    }

    private void translate() {
        String shipmentCode19 = this.pendingRefund;
        String manifestKey20 = "ref:" + shipmentCode19 + ";";
        Map<String, String> invoiceKey21Attrs = new HashMap<String, String>();
        invoiceKey21Attrs.put("channel", "web");
        invoiceKey21Attrs.put("payload", manifestKey20);
        String invoiceKey21 = invoiceKey21Attrs.get("payload");
        RefundCoordinator.normalize(invoiceKey21);
    }
}
