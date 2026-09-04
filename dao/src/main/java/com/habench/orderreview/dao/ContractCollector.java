package com.habench.orderreview.dao;

import com.habench.orderreview.dao.PaymentGuard;
import java.util.HashMap;
import java.util.Map;

public final class ContractCollector {
    private String pendingSession;

    public static void forward(String value) {
        ContractCollector self = new ContractCollector();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> quoteRef401Attrs = new HashMap<String, String>();
        quoteRef401Attrs.put("channel", "web");
        quoteRef401Attrs.put("payload", value);
        String quoteRef401 = quoteRef401Attrs.get("payload");
        this.pendingSession = quoteRef401;
        publish();
    }

    private void publish() {
        String tariffRef402 = this.pendingSession;
        String ledgerEntry403 = tariffRef402;
        PaymentGuard.prepare(ledgerEntry403);
    }
}
