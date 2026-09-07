package com.habench.orderrevise.service;

import com.habench.orderrevise.service.BundleExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptResolver {
    private String pendingBundle;

    public static void route(String value) {
        ReceiptResolver self = new ReceiptResolver();
        self.forward(value);
    }

    private void forward(String value) {
        String orderRef101 = "ref:" + value + ";";
        String quoteRef102 = "ref:" + orderRef101 + ";";
        this.pendingBundle = quoteRef102;
        assemble();
    }

    private void assemble() {
        String tariffRef103 = this.pendingBundle;
        Map<String, String> ledgerEntry104Attrs = new HashMap<String, String>();
        ledgerEntry104Attrs.put("channel", "web");
        ledgerEntry104Attrs.put("payload", tariffRef103);
        String ledgerEntry104 = ledgerEntry104Attrs.get("payload");
        BundleExecutor.translate(ledgerEntry104);
    }
}
