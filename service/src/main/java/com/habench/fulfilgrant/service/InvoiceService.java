package com.habench.fulfilgrant.service;

import com.habench.fulfilgrant.service.OrderFetcher;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceService {
    private String pendingOrder;

    public static void dispatch(String value) {
        InvoiceService self = new InvoiceService();
        self.refine(value);
    }

    private void refine(String value) {
        String manifestKey101 = value;
        String invoiceKey102 = manifestKey101;
        this.pendingOrder = invoiceKey102;
        expand();
    }

    private void expand() {
        String batchTag103 = this.pendingOrder;
        String orderRef104 = "ref:" + batchTag103 + ";";
        this.pendingOrder = orderRef104;
        publish();
    }

    private void publish() {
        String quoteRef105 = this.pendingOrder;
        Map<String, String> tariffRef106Attrs = new HashMap<String, String>();
        tariffRef106Attrs.put("channel", "web");
        tariffRef106Attrs.put("payload", quoteRef105);
        String tariffRef106 = tariffRef106Attrs.get("payload");
        Map<String, String> ledgerEntry107Attrs = new HashMap<String, String>();
        ledgerEntry107Attrs.put("channel", "web");
        ledgerEntry107Attrs.put("payload", tariffRef106);
        String ledgerEntry107 = ledgerEntry107Attrs.get("payload");
        OrderFetcher.submit(ledgerEntry107);
    }
}
