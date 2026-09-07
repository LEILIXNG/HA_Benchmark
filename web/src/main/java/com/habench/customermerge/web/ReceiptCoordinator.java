package com.habench.customermerge.web;

import com.habench.customermerge.web.LedgerRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCoordinator {
    private String pendingAccount;

    public static void forward(String value) {
        ReceiptCoordinator self = new ReceiptCoordinator();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String accountRef1 = value;
        this.pendingAccount = accountRef1;
        stage();
    }

    private void stage() {
        String voucherRef2 = this.pendingAccount;
        Map<String, String> paymentTag3Attrs = new HashMap<String, String>();
        paymentTag3Attrs.put("channel", "web");
        paymentTag3Attrs.put("payload", voucherRef2);
        String paymentTag3 = paymentTag3Attrs.get("payload");
        LedgerRuleSelector.publish(paymentTag3);
    }
}
