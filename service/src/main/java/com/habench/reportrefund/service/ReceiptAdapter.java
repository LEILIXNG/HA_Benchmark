package com.habench.reportrefund.service;

import com.habench.reportrefund.service.PaymentTranslator;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptAdapter {
    private String pendingTariff;

    public static void translate(String value) {
        ReceiptAdapter self = new ReceiptAdapter();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        this.pendingTariff = receiptKey201;
        collect();
    }

    private void collect() {
        String accountRef202 = this.pendingTariff;
        String voucherRef203 = accountRef202;
        this.pendingTariff = voucherRef203;
        register();
    }

    private void register() {
        String paymentTag204 = this.pendingTariff;
        String refundCode205 = paymentTag204;
        PaymentTranslator.compose(refundCode205);
    }
}
