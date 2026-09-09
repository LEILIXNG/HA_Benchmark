package com.habench.paymentbatch.web;

import com.habench.paymentbatch.service.RefundCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAdapter {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void compose(String value) {
        QuoteAdapter self = new QuoteAdapter();
        self.collect(value);
    }

    private void collect(String value) {
        String voucherRef1 = value;
        this.pendingReceipt = voucherRef1;
        stage();
    }

    private void stage() {
        String paymentTag2 = this.pendingReceipt;
        Map<String, String> refundCode3Attrs = new HashMap<String, String>();
        refundCode3Attrs.put("channel", "web");
        refundCode3Attrs.put("payload", paymentTag2);
        String refundCode3 = refundCode3Attrs.get("payload");
        cachedReceipt = refundCode3;
        enrich();
    }

    private void enrich() {
        String shipmentCode4 = cachedReceipt;
        String manifestKey5 = shipmentCode4;
        cachedReceipt = manifestKey5;
        normalize();
    }

    private void normalize() {
        String invoiceKey6 = cachedReceipt;
        Map<String, String> batchTag7Attrs = new HashMap<String, String>();
        batchTag7Attrs.put("channel", "web");
        batchTag7Attrs.put("payload", invoiceKey6);
        String batchTag7 = batchTag7Attrs.get("payload");
        this.pendingReceipt = batchTag7;
        publish();
    }

    private void publish() {
        String orderRef8 = this.pendingReceipt;
        Map<String, String> quoteRef9Attrs = new HashMap<String, String>();
        quoteRef9Attrs.put("channel", "web");
        quoteRef9Attrs.put("payload", orderRef8);
        String quoteRef9 = quoteRef9Attrs.get("payload");
        this.pendingReceipt = quoteRef9;
        prepare();
    }

    private void prepare() {
        String tariffRef10 = this.pendingReceipt;
        Map<String, String> ledgerEntry11Attrs = new HashMap<String, String>();
        ledgerEntry11Attrs.put("channel", "web");
        ledgerEntry11Attrs.put("payload", tariffRef10);
        String ledgerEntry11 = ledgerEntry11Attrs.get("payload");
        String channelTag12 = ledgerEntry11;
        cachedReceipt = channelTag12;
        refine();
    }

    private void refine() {
        String catalogKey13 = cachedReceipt;
        Map<String, String> receiptKey14Attrs = new HashMap<String, String>();
        receiptKey14Attrs.put("channel", "web");
        receiptKey14Attrs.put("payload", catalogKey13);
        String receiptKey14 = receiptKey14Attrs.get("payload");
        Map<String, String> accountRef15Attrs = new HashMap<String, String>();
        accountRef15Attrs.put("channel", "web");
        accountRef15Attrs.put("payload", receiptKey14);
        String accountRef15 = accountRef15Attrs.get("payload");
        RefundCoordinator.translate(accountRef15);
    }
}
