package com.habench.accountissue.service;

import com.habench.accountissue.service.QuoteValidator;
import java.util.HashMap;
import java.util.Map;

public final class AccountCoordinator {
    private String pendingRefund;

    public static void enrich(String value) {
        AccountCoordinator self = new AccountCoordinator();
        self.route(value);
    }

    private void route(String value) {
        Map<String, String> receiptKey101Attrs = new HashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("payload", value);
        String receiptKey101 = receiptKey101Attrs.get("payload");
        this.pendingRefund = receiptKey101;
        assemble();
    }

    private void assemble() {
        String accountRef102 = this.pendingRefund;
        String voucherRef103 = "ref:" + accountRef102 + ";";
        Map<String, String> paymentTag104Attrs = new HashMap<String, String>();
        paymentTag104Attrs.put("channel", "web");
        paymentTag104Attrs.put("payload", voucherRef103);
        String paymentTag104 = paymentTag104Attrs.get("payload");
        QuoteValidator.reconcile(paymentTag104);
    }
}
