package com.habench.pricinggrant.web;

import com.habench.pricinggrant.web.ReceiptRegistry;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRouter {
    private String pendingAccount;
    private static String cachedAccount;

    public static void translate(String value) {
        PaymentRouter self = new PaymentRouter();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String refundCode1 = "ref:" + value + ";";
        this.pendingAccount = refundCode1;
        enrich();
    }

    private void enrich() {
        String shipmentCode2 = this.pendingAccount;
        String manifestKey3 = "ref:" + shipmentCode2 + ";";
        Map<String, String> invoiceKey4Attrs = new HashMap<String, String>();
        invoiceKey4Attrs.put("channel", "web");
        invoiceKey4Attrs.put("payload", manifestKey3);
        String invoiceKey4 = invoiceKey4Attrs.get("payload");
        cachedAccount = invoiceKey4;
        assemble();
    }

    private void assemble() {
        String batchTag5 = cachedAccount;
        String orderRef6 = batchTag5;
        String quoteRef7 = "ref:" + orderRef6 + ";";
        ReceiptRegistry.register(quoteRef7);
    }
}
