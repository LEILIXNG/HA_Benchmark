package com.habench.paymentimport.service;

import com.habench.paymentimport.service.InvoicePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class BatchTranslator {
    private String pendingShipment;

    public static void compose(String value) {
        BatchTranslator self = new BatchTranslator();
        self.attach(value);
    }

    private void attach(String value) {
        String catalogKey201 = value;
        Map<String, String> receiptKey202Attrs = new HashMap<String, String>();
        receiptKey202Attrs.put("channel", "web");
        receiptKey202Attrs.put("payload", catalogKey201);
        String receiptKey202 = receiptKey202Attrs.get("payload");
        this.pendingShipment = receiptKey202;
        assemble();
    }

    private void assemble() {
        String accountRef203 = this.pendingShipment;
        String voucherRef204 = "ref:" + accountRef203 + ";";
        InvoicePlanSelector.register(voucherRef204);
    }
}
