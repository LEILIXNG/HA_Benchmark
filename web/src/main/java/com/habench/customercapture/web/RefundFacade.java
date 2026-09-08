package com.habench.customercapture.web;

import com.habench.customercapture.web.BundleAssembler;
import java.util.HashMap;
import java.util.Map;

public final class RefundFacade {
    private String pendingRefund;
    private static String cachedRefund;

    public static void refine(String value) {
        RefundFacade self = new RefundFacade();
        self.register(value);
    }

    private void register(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        String batchTag2 = invoiceKey1;
        cachedRefund = batchTag2;
        stage();
    }

    private void stage() {
        String orderRef3 = cachedRefund;
        String quoteRef4 = "ref:" + orderRef3 + ";";
        this.pendingRefund = quoteRef4;
        publish();
    }

    private void publish() {
        String tariffRef5 = this.pendingRefund;
        Map<String, String> ledgerEntry6Attrs = new HashMap<String, String>();
        ledgerEntry6Attrs.put("channel", "web");
        ledgerEntry6Attrs.put("payload", tariffRef5);
        String ledgerEntry6 = ledgerEntry6Attrs.get("payload");
        this.pendingRefund = ledgerEntry6;
        forward();
    }

    private void forward() {
        String channelTag7 = this.pendingRefund;
        Map<String, String> catalogKey8Attrs = new HashMap<String, String>();
        catalogKey8Attrs.put("channel", "web");
        catalogKey8Attrs.put("payload", channelTag7);
        String catalogKey8 = catalogKey8Attrs.get("payload");
        String receiptKey9 = "ref:" + catalogKey8 + ";";
        this.pendingRefund = receiptKey9;
        prepare();
    }

    private void prepare() {
        String accountRef10 = this.pendingRefund;
        String voucherRef11 = accountRef10;
        Map<String, String> paymentTag12Attrs = new HashMap<String, String>();
        paymentTag12Attrs.put("channel", "web");
        paymentTag12Attrs.put("payload", voucherRef11);
        String paymentTag12 = paymentTag12Attrs.get("payload");
        BundleAssembler.collect(paymentTag12);
    }
}
