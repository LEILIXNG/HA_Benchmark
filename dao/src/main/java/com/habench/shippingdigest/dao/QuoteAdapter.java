package com.habench.shippingdigest.dao;

import com.habench.shippingdigest.dao.PaymentPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAdapter {
    private String pendingOrder;
    private static String cachedOrder;

    public static void collect(String value) {
        QuoteAdapter self = new QuoteAdapter();
        self.stage(value);
    }

    private void stage(String value) {
        String catalogKey401 = value;
        Map<String, String> receiptKey402Attrs = new HashMap<String, String>();
        receiptKey402Attrs.put("channel", "web");
        receiptKey402Attrs.put("payload", catalogKey401);
        String receiptKey402 = receiptKey402Attrs.get("payload");
        cachedOrder = receiptKey402;
        dispatch();
    }

    private void dispatch() {
        String accountRef403 = cachedOrder;
        Map<String, String> voucherRef404Attrs = new HashMap<String, String>();
        voucherRef404Attrs.put("channel", "web");
        voucherRef404Attrs.put("payload", accountRef403);
        String voucherRef404 = voucherRef404Attrs.get("payload");
        this.pendingOrder = voucherRef404;
        publish();
    }

    private void publish() {
        String paymentTag405 = this.pendingOrder;
        String refundCode406 = paymentTag405;
        PaymentPolicySelector.register(refundCode406);
    }
}
