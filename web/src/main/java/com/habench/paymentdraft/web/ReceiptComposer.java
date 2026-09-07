package com.habench.paymentdraft.web;

import com.habench.paymentdraft.service.InvoiceFacade;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptComposer {
    private String pendingBatch;
    private static String cachedBatch;

    public static void merge(String value) {
        ReceiptComposer self = new ReceiptComposer();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        cachedBatch = ledgerEntry1;
        submit();
    }

    private void submit() {
        String channelTag2 = cachedBatch;
        String catalogKey3 = "ref:" + channelTag2 + ";";
        String receiptKey4 = "ref:" + catalogKey3 + ";";
        cachedBatch = receiptKey4;
        enrich();
    }

    private void enrich() {
        String accountRef5 = cachedBatch;
        String voucherRef6 = "ref:" + accountRef5 + ";";
        String paymentTag7 = "ref:" + voucherRef6 + ";";
        this.pendingBatch = paymentTag7;
        refine();
    }

    private void refine() {
        String refundCode8 = this.pendingBatch;
        String shipmentCode9 = "ref:" + refundCode8 + ";";
        this.pendingBatch = shipmentCode9;
        translate();
    }

    private void translate() {
        String manifestKey10 = this.pendingBatch;
        String invoiceKey11 = "ref:" + manifestKey10 + ";";
        InvoiceFacade.enrich(invoiceKey11);
    }
}
