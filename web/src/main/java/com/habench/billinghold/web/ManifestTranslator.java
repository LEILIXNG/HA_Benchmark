package com.habench.billinghold.web;

import com.habench.billinghold.web.LedgerRouter;
import java.util.HashMap;
import java.util.Map;

public final class ManifestTranslator {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void attach(String value) {
        ManifestTranslator self = new ManifestTranslator();
        self.prepare(value);
    }

    private void prepare(String value) {
        String tariffRef1 = "ref:" + value + ";";
        Map<String, String> ledgerEntry2Attrs = new HashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("payload", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get("payload");
        this.pendingReceipt = ledgerEntry2;
        refine();
    }

    private void refine() {
        String channelTag3 = this.pendingReceipt;
        Map<String, String> catalogKey4Attrs = new HashMap<String, String>();
        catalogKey4Attrs.put("channel", "web");
        catalogKey4Attrs.put("payload", channelTag3);
        String catalogKey4 = catalogKey4Attrs.get("payload");
        Map<String, String> receiptKey5Attrs = new HashMap<String, String>();
        receiptKey5Attrs.put("channel", "web");
        receiptKey5Attrs.put("payload", catalogKey4);
        String receiptKey5 = receiptKey5Attrs.get("payload");
        this.pendingReceipt = receiptKey5;
        assemble();
    }

    private void assemble() {
        String accountRef6 = this.pendingReceipt;
        String voucherRef7 = "ref:" + accountRef6 + ";";
        Map<String, String> paymentTag8Attrs = new HashMap<String, String>();
        paymentTag8Attrs.put("channel", "web");
        paymentTag8Attrs.put("payload", voucherRef7);
        String paymentTag8 = paymentTag8Attrs.get("payload");
        this.pendingReceipt = paymentTag8;
        normalize();
    }

    private void normalize() {
        String refundCode9 = this.pendingReceipt;
        String shipmentCode10 = "ref:" + refundCode9 + ";";
        cachedReceipt = shipmentCode10;
        expand();
    }

    private void expand() {
        String manifestKey11 = cachedReceipt;
        String invoiceKey12 = "ref:" + manifestKey11 + ";";
        String batchTag13 = invoiceKey12;
        LedgerRouter.resolve(batchTag13);
    }
}
