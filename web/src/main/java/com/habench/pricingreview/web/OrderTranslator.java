package com.habench.pricingreview.web;

import com.habench.pricingreview.web.VoucherEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class OrderTranslator {
    private String pendingVoucher;

    public static void publish(String value) {
        OrderTranslator self = new OrderTranslator();
        self.submit(value);
    }

    private void submit(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        this.pendingVoucher = receiptKey201;
        expand();
    }

    private void expand() {
        String accountRef202 = this.pendingVoucher;
        Map<String, String> voucherRef203Attrs = new HashMap<String, String>();
        voucherRef203Attrs.put("channel", "web");
        voucherRef203Attrs.put("payload", accountRef202);
        String voucherRef203 = voucherRef203Attrs.get("payload");
        String paymentTag204 = voucherRef203;
        VoucherEvaluator.assemble(paymentTag204);
    }
}
