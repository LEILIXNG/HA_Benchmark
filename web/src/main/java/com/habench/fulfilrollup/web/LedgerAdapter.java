package com.habench.fulfilrollup.web;

import com.habench.fulfilrollup.service.ReceiptService;
import java.util.HashMap;
import java.util.Map;

public final class LedgerAdapter {
    private String pendingQuote;
    private static String cachedQuote;

    public static void refine(String value) {
        LedgerAdapter self = new LedgerAdapter();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String manifestKey1 = value;
        cachedQuote = manifestKey1;
        submit();
    }

    private void submit() {
        String invoiceKey2 = cachedQuote;
        String batchTag3 = "ref:" + invoiceKey2 + ";";
        String orderRef4 = batchTag3;
        this.pendingQuote = orderRef4;
        enrich();
    }

    private void enrich() {
        String quoteRef5 = this.pendingQuote;
        Map<String, String> tariffRef6Attrs = new HashMap<String, String>();
        tariffRef6Attrs.put("channel", "web");
        tariffRef6Attrs.put("payload", quoteRef5);
        String tariffRef6 = tariffRef6Attrs.get("payload");
        String ledgerEntry7 = "ref:" + tariffRef6 + ";";
        this.pendingQuote = ledgerEntry7;
        collect();
    }

    private void collect() {
        String channelTag8 = this.pendingQuote;
        Map<String, String> catalogKey9Attrs = new HashMap<String, String>();
        catalogKey9Attrs.put("channel", "web");
        catalogKey9Attrs.put("payload", channelTag8);
        String catalogKey9 = catalogKey9Attrs.get("payload");
        Map<String, String> receiptKey10Attrs = new HashMap<String, String>();
        receiptKey10Attrs.put("channel", "web");
        receiptKey10Attrs.put("payload", catalogKey9);
        String receiptKey10 = receiptKey10Attrs.get("payload");
        ReceiptService.publish(receiptKey10);
    }
}
