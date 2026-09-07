package com.habench.catalogrefund.web;

import com.habench.catalogrefund.service.CatalogCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceEnricher {
    private String pendingBatch;
    private static String cachedBatch;

    public static void route(String value) {
        InvoiceEnricher self = new InvoiceEnricher();
        self.refine(value);
    }

    private void refine(String value) {
        String accountRef1 = "ref:" + value + ";";
        Map<String, String> voucherRef2Attrs = new HashMap<String, String>();
        voucherRef2Attrs.put("channel", "web");
        voucherRef2Attrs.put("payload", accountRef1);
        String voucherRef2 = voucherRef2Attrs.get("payload");
        this.pendingBatch = voucherRef2;
        submit();
    }

    private void submit() {
        String paymentTag3 = this.pendingBatch;
        Map<String, String> refundCode4Attrs = new HashMap<String, String>();
        refundCode4Attrs.put("channel", "web");
        refundCode4Attrs.put("payload", paymentTag3);
        String refundCode4 = refundCode4Attrs.get("payload");
        this.pendingBatch = refundCode4;
        translate();
    }

    private void translate() {
        String shipmentCode5 = this.pendingBatch;
        String manifestKey6 = shipmentCode5;
        this.pendingBatch = manifestKey6;
        reconcile();
    }

    private void reconcile() {
        String invoiceKey7 = this.pendingBatch;
        String batchTag8 = invoiceKey7;
        String orderRef9 = batchTag8;
        cachedBatch = orderRef9;
        assemble();
    }

    private void assemble() {
        String quoteRef10 = cachedBatch;
        String tariffRef11 = quoteRef10;
        String ledgerEntry12 = "ref:" + tariffRef11 + ";";
        this.pendingBatch = ledgerEntry12;
        resolve();
    }

    private void resolve() {
        String channelTag13 = this.pendingBatch;
        Map<String, String> catalogKey14Attrs = new HashMap<String, String>();
        catalogKey14Attrs.put("channel", "web");
        catalogKey14Attrs.put("payload", channelTag13);
        String catalogKey14 = catalogKey14Attrs.get("payload");
        this.pendingBatch = catalogKey14;
        merge();
    }

    private void merge() {
        String receiptKey15 = this.pendingBatch;
        String accountRef16 = receiptKey15;
        CatalogCoordinator.normalize(accountRef16);
    }
}
