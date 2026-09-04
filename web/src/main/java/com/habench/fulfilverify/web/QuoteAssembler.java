package com.habench.fulfilverify.web;

import com.habench.fulfilverify.service.ContractBroker;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAssembler {
    private String pendingInvoice;

    public static void reconcile(String value) {
        QuoteAssembler self = new QuoteAssembler();
        self.merge(value);
    }

    private void merge(String value) {
        String manifestKey101 = value;
        Map<String, String> invoiceKey102Attrs = new HashMap<String, String>();
        invoiceKey102Attrs.put("channel", "web");
        invoiceKey102Attrs.put("payload", manifestKey101);
        String invoiceKey102 = invoiceKey102Attrs.get("payload");
        this.pendingInvoice = invoiceKey102;
        normalize();
    }

    private void normalize() {
        String batchTag103 = this.pendingInvoice;
        String orderRef104 = "ref:" + batchTag103 + ";";
        this.pendingInvoice = orderRef104;
        publish();
    }

    private void publish() {
        String quoteRef105 = this.pendingInvoice;
        String tariffRef106 = quoteRef105;
        this.pendingInvoice = tariffRef106;
        resolve();
    }

    private void resolve() {
        String ledgerEntry107 = this.pendingInvoice;
        String channelTag108 = ledgerEntry107;
        Map<String, String> catalogKey109Attrs = new HashMap<String, String>();
        catalogKey109Attrs.put("channel", "web");
        catalogKey109Attrs.put("payload", channelTag108);
        String catalogKey109 = catalogKey109Attrs.get("payload");
        ContractBroker.stage(catalogKey109);
    }
}
