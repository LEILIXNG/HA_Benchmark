package com.habench.paymentnotice.web;

import com.habench.paymentnotice.web.PaymentRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundRegistry {
    private String pendingChannel;

    public static void submit(String value) {
        RefundRegistry self = new RefundRegistry();
        self.merge(value);
    }

    private void merge(String value) {
        String accountRef1 = value;
        this.pendingChannel = accountRef1;
        collect();
    }

    private void collect() {
        String voucherRef2 = this.pendingChannel;
        Map<String, String> paymentTag3Attrs = new HashMap<String, String>();
        paymentTag3Attrs.put("channel", "web");
        paymentTag3Attrs.put("payload", voucherRef2);
        String paymentTag3 = paymentTag3Attrs.get("payload");
        PaymentRuleSelector.publish(paymentTag3);
    }
}
