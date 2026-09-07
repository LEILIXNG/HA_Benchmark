package com.habench.paymentbatch.service;

import com.habench.paymentbatch.dao.QuotePolicy;
import java.util.HashMap;
import java.util.Map;

public final class VoucherCoordinator {
    private String pendingVoucher;

    public static void forward(String value) {
        VoucherCoordinator self = new VoucherCoordinator();
        self.translate(value);
    }

    private void translate(String value) {
        String channelTag401 = "ref:" + value + ";";
        this.pendingVoucher = channelTag401;
        normalize();
    }

    private void normalize() {
        String catalogKey402 = this.pendingVoucher;
        Map<String, String> receiptKey403Attrs = new HashMap<String, String>();
        receiptKey403Attrs.put("channel", "web");
        receiptKey403Attrs.put("payload", catalogKey402);
        String receiptKey403 = receiptKey403Attrs.get("payload");
        String accountRef404 = receiptKey403;
        QuotePolicy.refine(accountRef404);
    }
}
