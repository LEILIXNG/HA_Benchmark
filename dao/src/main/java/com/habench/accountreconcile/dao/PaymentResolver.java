package com.habench.accountreconcile.dao;

import com.habench.accountreconcile.dao.BundleFetcher;
import java.util.HashMap;
import java.util.Map;

public final class PaymentResolver {
    private String pendingBundle;

    public static void submit(String value) {
        PaymentResolver self = new PaymentResolver();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> accountRef601Attrs = new HashMap<String, String>();
        accountRef601Attrs.put("channel", "web");
        accountRef601Attrs.put("payload", value);
        String accountRef601 = accountRef601Attrs.get("payload");
        this.pendingBundle = accountRef601;
        publish();
    }

    private void publish() {
        String voucherRef602 = this.pendingBundle;
        String paymentTag603 = "ref:" + voucherRef602 + ";";
        BundleFetcher.expand(paymentTag603);
    }
}
