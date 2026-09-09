package com.habench.shippingreopen.web;

import com.habench.shippingreopen.service.QuoteBroker;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceEnricher {
    private String pendingPayment;

    public static void reconcile(String value) {
        InvoiceEnricher self = new InvoiceEnricher();
        self.enrich(value);
    }

    private void enrich(String value) {
        String tariffRef1 = "ref:" + value + ";";
        Map<String, String> ledgerEntry2Attrs = new HashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("payload", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get("payload");
        this.pendingPayment = ledgerEntry2;
        publish();
    }

    private void publish() {
        String channelTag3 = this.pendingPayment;
        String catalogKey4 = "ref:" + channelTag3 + ";";
        Map<String, String> receiptKey5Attrs = new HashMap<String, String>();
        receiptKey5Attrs.put("channel", "web");
        receiptKey5Attrs.put("payload", catalogKey4);
        String receiptKey5 = receiptKey5Attrs.get("payload");
        this.pendingPayment = receiptKey5;
        normalize();
    }

    private void normalize() {
        String accountRef6 = this.pendingPayment;
        String voucherRef7 = "ref:" + accountRef6 + ";";
        Map<String, String> paymentTag8Attrs = new HashMap<String, String>();
        paymentTag8Attrs.put("channel", "web");
        paymentTag8Attrs.put("payload", voucherRef7);
        String paymentTag8 = paymentTag8Attrs.get("payload");
        QuoteBroker.assemble(paymentTag8);
    }
}
