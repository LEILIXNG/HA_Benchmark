package com.habench.orderlookup.web;

import com.habench.orderlookup.service.OrderComposer;
import java.util.HashMap;
import java.util.Map;

public final class RefundCoordinator {
    private String pendingContract;

    public static void refine(String value) {
        RefundCoordinator self = new RefundCoordinator();
        self.compose(value);
    }

    private void compose(String value) {
        String catalogKey101 = value;
        Map<String, String> receiptKey102Attrs = new HashMap<String, String>();
        receiptKey102Attrs.put("channel", "web");
        receiptKey102Attrs.put("payload", catalogKey101);
        String receiptKey102 = receiptKey102Attrs.get("payload");
        this.pendingContract = receiptKey102;
        collect();
    }

    private void collect() {
        String accountRef103 = this.pendingContract;
        String voucherRef104 = accountRef103;
        this.pendingContract = voucherRef104;
        assemble();
    }

    private void assemble() {
        String paymentTag105 = this.pendingContract;
        Map<String, String> refundCode106Attrs = new HashMap<String, String>();
        refundCode106Attrs.put("channel", "web");
        refundCode106Attrs.put("payload", paymentTag105);
        String refundCode106 = refundCode106Attrs.get("payload");
        OrderComposer.merge(refundCode106);
    }
}
