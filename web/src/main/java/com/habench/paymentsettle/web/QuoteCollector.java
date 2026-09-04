package com.habench.paymentsettle.web;

import com.habench.paymentsettle.web.SessionPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteCollector {
    private String pendingTariff;

    public static void normalize(String value) {
        QuoteCollector self = new QuoteCollector();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String invoiceKey101 = value;
        this.pendingTariff = invoiceKey101;
        publish();
    }

    private void publish() {
        String batchTag102 = this.pendingTariff;
        String orderRef103 = "ref:" + batchTag102 + ";";
        Map<String, String> quoteRef104Attrs = new HashMap<String, String>();
        quoteRef104Attrs.put("channel", "web");
        quoteRef104Attrs.put("payload", orderRef103);
        String quoteRef104 = quoteRef104Attrs.get("payload");
        SessionPolicySelector.forward(quoteRef104);
    }
}
