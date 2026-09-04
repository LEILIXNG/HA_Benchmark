package com.habench.billingreconcile.service;

import com.habench.billingreconcile.service.TariffStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleTranslator {
    private String pendingPayment;

    public static void publish(String value) {
        BundleTranslator self = new BundleTranslator();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        this.pendingPayment = receiptKey201;
        expand();
    }

    private void expand() {
        String accountRef202 = this.pendingPayment;
        String voucherRef203 = accountRef202;
        this.pendingPayment = voucherRef203;
        route();
    }

    private void route() {
        String paymentTag204 = this.pendingPayment;
        Map<String, String> refundCode205Attrs = new HashMap<String, String>();
        refundCode205Attrs.put("channel", "web");
        refundCode205Attrs.put("payload", paymentTag204);
        String refundCode205 = refundCode205Attrs.get("payload");
        TariffStrategySelector.merge(refundCode205);
    }
}
