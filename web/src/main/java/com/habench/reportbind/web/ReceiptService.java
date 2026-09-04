package com.habench.reportbind.web;

import com.habench.reportbind.web.PaymentCollector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptService {
    private String pendingContract;

    public static void route(String value) {
        ReceiptService self = new ReceiptService();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        this.pendingContract = ledgerEntry101;
        refine();
    }

    private void refine() {
        String channelTag102 = this.pendingContract;
        String catalogKey103 = "ref:" + channelTag102 + ";";
        Map<String, String> receiptKey104Attrs = new HashMap<String, String>();
        receiptKey104Attrs.put("channel", "web");
        receiptKey104Attrs.put("payload", catalogKey103);
        String receiptKey104 = receiptKey104Attrs.get("payload");
        PaymentCollector.enrich(receiptKey104);
    }
}
