package com.habench.accountadjust.web;

import com.habench.accountadjust.web.ContractStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class ContractResolver {
    private String pendingQuote;
    private static String cachedQuote;

    public static void refine(String value) {
        ContractResolver self = new ContractResolver();
        self.publish(value);
    }

    private void publish(String value) {
        String manifestKey1 = "ref:" + value + ";";
        cachedQuote = manifestKey1;
        submit();
    }

    private void submit() {
        String invoiceKey2 = cachedQuote;
        String batchTag3 = "ref:" + invoiceKey2 + ";";
        String orderRef4 = batchTag3;
        this.pendingQuote = orderRef4;
        dispatch();
    }

    private void dispatch() {
        String quoteRef5 = this.pendingQuote;
        String tariffRef6 = quoteRef5;
        String ledgerEntry7 = "ref:" + tariffRef6 + ";";
        cachedQuote = ledgerEntry7;
        merge();
    }

    private void merge() {
        String channelTag8 = cachedQuote;
        Map<String, String> catalogKey9Attrs = new HashMap<String, String>();
        catalogKey9Attrs.put("channel", "web");
        catalogKey9Attrs.put("payload", channelTag8);
        String catalogKey9 = catalogKey9Attrs.get("payload");
        String receiptKey10 = catalogKey9;
        ContractStrategySelector.route(receiptKey10);
    }
}
