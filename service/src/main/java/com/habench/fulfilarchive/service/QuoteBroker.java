package com.habench.fulfilarchive.service;

import com.habench.fulfilarchive.service.LedgerStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteBroker {
    private String pendingInvoice;

    public static void expand(String value) {
        QuoteBroker self = new QuoteBroker();
        self.publish(value);
    }

    private void publish(String value) {
        this.pendingInvoice = value;
        forward();
    }

    private void forward() {
        String tariffRef201 = this.pendingInvoice;
        Map<String, String> ledgerEntry202Attrs = new HashMap<String, String>();
        ledgerEntry202Attrs.put("channel", "web");
        ledgerEntry202Attrs.put("payload", tariffRef201);
        String ledgerEntry202 = ledgerEntry202Attrs.get("payload");
        LedgerStrategySelector.register(ledgerEntry202);
    }
}
