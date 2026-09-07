package com.habench.billingcapture.service;

import com.habench.billingcapture.service.ContractFilter;
import java.util.HashMap;
import java.util.Map;

public final class QuoteCollector {
    private String pendingSession;

    public static void publish(String value) {
        QuoteCollector self = new QuoteCollector();
        self.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        String batchTag102 = invoiceKey101;
        this.pendingSession = batchTag102;
        assemble();
    }

    private void assemble() {
        String orderRef103 = this.pendingSession;
        String quoteRef104 = orderRef103;
        this.pendingSession = quoteRef104;
        prepare();
    }

    private void prepare() {
        String tariffRef105 = this.pendingSession;
        Map<String, String> ledgerEntry106Attrs = new HashMap<String, String>();
        ledgerEntry106Attrs.put("channel", "web");
        ledgerEntry106Attrs.put("payload", tariffRef105);
        String ledgerEntry106 = ledgerEntry106Attrs.get("payload");
        String channelTag107 = ledgerEntry106;
        ContractFilter.enrich(channelTag107);
    }
}
