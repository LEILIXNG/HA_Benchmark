package com.habench.shippingrevise.service;

import com.habench.shippingrevise.service.ReceiptRegistry;
import java.util.HashMap;
import java.util.Map;

public final class OrderCollector {
    private String pendingQuote;
    private static String cachedQuote;

    public static void prepare(String value) {
        OrderCollector self = new OrderCollector();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("payload", value);
        String tariffRef101 = tariffRef101Attrs.get("payload");
        String ledgerEntry102 = tariffRef101;
        this.pendingQuote = ledgerEntry102;
        expand();
    }

    private void expand() {
        String channelTag103 = this.pendingQuote;
        Map<String, String> catalogKey104Attrs = new HashMap<String, String>();
        catalogKey104Attrs.put("channel", "web");
        catalogKey104Attrs.put("payload", channelTag103);
        String catalogKey104 = catalogKey104Attrs.get("payload");
        cachedQuote = catalogKey104;
        submit();
    }

    private void submit() {
        String receiptKey105 = cachedQuote;
        String accountRef106 = receiptKey105;
        ReceiptRegistry.attach(accountRef106);
    }
}
