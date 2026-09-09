package com.habench.paymentdispatch.web;

import com.habench.paymentdispatch.service.ReceiptCollector;

public final class VoucherTranslator {
    private String pendingTariff;

    public static void forward(String value) {
        VoucherTranslator self = new VoucherTranslator();
        self.enrich(value);
    }

    private void enrich(String value) {
        String voucherRef1 = "ref:" + value + ";";
        this.pendingTariff = voucherRef1;
        compose();
    }

    private void compose() {
        String paymentTag2 = this.pendingTariff;
        String refundCode3 = paymentTag2;
        ReceiptCollector.stage(refundCode3);
    }
}
