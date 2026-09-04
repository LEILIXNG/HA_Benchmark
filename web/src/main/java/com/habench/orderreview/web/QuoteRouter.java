package com.habench.orderreview.web;

import com.habench.orderreview.web.ReceiptEnricher;
import java.util.HashMap;
import java.util.Map;

public final class QuoteRouter {
    private String pendingSession;

    public static void prepare(String value) {
        QuoteRouter self = new QuoteRouter();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String receiptKey1 = value;
        this.pendingSession = receiptKey1;
        publish();
    }

    private void publish() {
        String accountRef2 = this.pendingSession;
        Map<String, String> voucherRef3Attrs = new HashMap<String, String>();
        voucherRef3Attrs.put("channel", "web");
        voucherRef3Attrs.put("payload", accountRef2);
        String voucherRef3 = voucherRef3Attrs.get("payload");
        String paymentTag4 = "ref:" + voucherRef3 + ";";
        ReceiptEnricher.dispatch(paymentTag4);
    }
}
