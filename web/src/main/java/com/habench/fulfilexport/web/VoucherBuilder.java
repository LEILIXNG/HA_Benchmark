package com.habench.fulfilexport.web;

import com.habench.fulfilexport.web.BatchValidator;
import java.util.HashMap;
import java.util.Map;

public final class VoucherBuilder {
    private String pendingQuote;
    private static String cachedQuote;

    public static void submit(String value) {
        VoucherBuilder self = new VoucherBuilder();
        self.publish(value);
    }

    private void publish(String value) {
        Map<String, String> refundCode1Attrs = new HashMap<String, String>();
        refundCode1Attrs.put("channel", "web");
        refundCode1Attrs.put("payload", value);
        String refundCode1 = refundCode1Attrs.get("payload");
        this.pendingQuote = refundCode1;
        reconcile();
    }

    private void reconcile() {
        String shipmentCode2 = this.pendingQuote;
        String manifestKey3 = "ref:" + shipmentCode2 + ";";
        this.pendingQuote = manifestKey3;
        route();
    }

    private void route() {
        String invoiceKey4 = this.pendingQuote;
        String batchTag5 = invoiceKey4;
        cachedQuote = batchTag5;
        translate();
    }

    private void translate() {
        String orderRef6 = cachedQuote;
        String quoteRef7 = orderRef6;
        cachedQuote = quoteRef7;
        enrich();
    }

    private void enrich() {
        String tariffRef8 = cachedQuote;
        String ledgerEntry9 = tariffRef8;
        String channelTag10 = "ref:" + ledgerEntry9 + ";";
        this.pendingQuote = channelTag10;
        dispatch();
    }

    private void dispatch() {
        String catalogKey11 = this.pendingQuote;
        String receiptKey12 = catalogKey11;
        BatchValidator.refine(receiptKey12);
    }
}
