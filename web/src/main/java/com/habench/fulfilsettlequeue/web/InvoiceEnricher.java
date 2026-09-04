package com.habench.fulfilsettlequeue.web;

import com.habench.fulfilsettlequeue.service.BatchTranslator;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceEnricher {
    private String pendingManifest;
    private static String cachedManifest;

    public static void assemble(String value) {
        InvoiceEnricher self = new InvoiceEnricher();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        cachedManifest = ledgerEntry1;
        submit();
    }

    private void submit() {
        String channelTag2 = cachedManifest;
        String catalogKey3 = "ref:" + channelTag2 + ";";
        String receiptKey4 = "ref:" + catalogKey3 + ";";
        cachedManifest = receiptKey4;
        publish();
    }

    private void publish() {
        String accountRef5 = cachedManifest;
        String voucherRef6 = "ref:" + accountRef5 + ";";
        String paymentTag7 = "ref:" + voucherRef6 + ";";
        this.pendingManifest = paymentTag7;
        translate();
    }

    private void translate() {
        String refundCode8 = this.pendingManifest;
        String shipmentCode9 = "ref:" + refundCode8 + ";";
        this.pendingManifest = shipmentCode9;
        dispatch();
    }

    private void dispatch() {
        String manifestKey10 = this.pendingManifest;
        String invoiceKey11 = "ref:" + manifestKey10 + ";";
        BatchTranslator.submit(invoiceKey11);
    }
}
