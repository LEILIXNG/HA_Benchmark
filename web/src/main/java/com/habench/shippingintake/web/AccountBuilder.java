package com.habench.shippingintake.web;

import com.habench.shippingintake.web.BundleStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountBuilder {
    private String pendingInvoice;

    public static void assemble(String value) {
        AccountBuilder self = new AccountBuilder();
        self.compose(value);
    }

    private void compose(String value) {
        String catalogKey1 = value;
        this.pendingInvoice = catalogKey1;
        enrich();
    }

    private void enrich() {
        String receiptKey2 = this.pendingInvoice;
        Map<String, String> accountRef3Attrs = new HashMap<String, String>();
        accountRef3Attrs.put("channel", "web");
        accountRef3Attrs.put("payload", receiptKey2);
        String accountRef3 = accountRef3Attrs.get("payload");
        BundleStrategySelector.route(accountRef3);
    }
}
