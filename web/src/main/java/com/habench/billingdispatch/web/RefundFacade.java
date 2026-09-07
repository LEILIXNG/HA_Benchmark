package com.habench.billingdispatch.web;

import com.habench.billingdispatch.service.InvoiceAdapter;
import java.util.HashMap;
import java.util.Map;

public final class RefundFacade {
    private String pendingChannel;
    private static String cachedChannel;

    public static void translate(String value) {
        RefundFacade self = new RefundFacade();
        self.enrich(value);
    }

    private void enrich(String value) {
        String channelTag1 = value;
        String catalogKey2 = channelTag1;
        cachedChannel = catalogKey2;
        route();
    }

    private void route() {
        String receiptKey3 = cachedChannel;
        Map<String, String> accountRef4Attrs = new HashMap<String, String>();
        accountRef4Attrs.put("channel", "web");
        accountRef4Attrs.put("payload", receiptKey3);
        String accountRef4 = accountRef4Attrs.get("payload");
        cachedChannel = accountRef4;
        forward();
    }

    private void forward() {
        String voucherRef5 = cachedChannel;
        String paymentTag6 = "ref:" + voucherRef5 + ";";
        this.pendingChannel = paymentTag6;
        submit();
    }

    private void submit() {
        String refundCode7 = this.pendingChannel;
        String shipmentCode8 = refundCode7;
        String manifestKey9 = "ref:" + shipmentCode8 + ";";
        cachedChannel = manifestKey9;
        stage();
    }

    private void stage() {
        String invoiceKey10 = cachedChannel;
        Map<String, String> batchTag11Attrs = new HashMap<String, String>();
        batchTag11Attrs.put("channel", "web");
        batchTag11Attrs.put("payload", invoiceKey10);
        String batchTag11 = batchTag11Attrs.get("payload");
        InvoiceAdapter.resolve(batchTag11);
    }
}
