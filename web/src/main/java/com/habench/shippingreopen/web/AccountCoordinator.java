package com.habench.shippingreopen.web;

import com.habench.shippingreopen.web.ReceiptRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountCoordinator {
    private String pendingQuote;

    public static void reconcile(String value) {
        AccountCoordinator self = new AccountCoordinator();
        self.route(value);
    }

    private void route(String value) {
        String manifestKey201 = value;
        Map<String, String> invoiceKey202Attrs = new HashMap<String, String>();
        invoiceKey202Attrs.put("channel", "web");
        invoiceKey202Attrs.put("payload", manifestKey201);
        String invoiceKey202 = invoiceKey202Attrs.get("payload");
        this.pendingQuote = invoiceKey202;
        publish();
    }

    private void publish() {
        String batchTag203 = this.pendingQuote;
        Map<String, String> orderRef204Attrs = new HashMap<String, String>();
        orderRef204Attrs.put("channel", "web");
        orderRef204Attrs.put("payload", batchTag203);
        String orderRef204 = orderRef204Attrs.get("payload");
        ReceiptRuleSelector.compose(orderRef204);
    }
}
