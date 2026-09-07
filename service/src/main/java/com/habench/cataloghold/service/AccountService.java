package com.habench.cataloghold.service;

import com.habench.cataloghold.dao.ReceiptRegistry;
import java.util.HashMap;
import java.util.Map;

public final class AccountService {
    private String pendingBundle;

    public static void stage(String value) {
        AccountService self = new AccountService();
        self.route(value);
    }

    private void route(String value) {
        String accountRef101 = value;
        this.pendingBundle = accountRef101;
        translate();
    }

    private void translate() {
        String voucherRef102 = this.pendingBundle;
        Map<String, String> paymentTag103Attrs = new HashMap<String, String>();
        paymentTag103Attrs.put("channel", "web");
        paymentTag103Attrs.put("payload", voucherRef102);
        String paymentTag103 = paymentTag103Attrs.get("payload");
        String refundCode104 = paymentTag103;
        ReceiptRegistry.assemble(refundCode104);
    }
}
