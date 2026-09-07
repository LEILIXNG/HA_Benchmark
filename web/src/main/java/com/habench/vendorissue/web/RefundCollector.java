package com.habench.vendorissue.web;

import com.habench.vendorissue.web.TariffScreen;

public final class RefundCollector {
    private String pendingPayment;

    public static void compose(String value) {
        RefundCollector self = new RefundCollector();
        self.publish(value);
    }

    private void publish(String value) {
        String receiptKey101 = value;
        this.pendingPayment = receiptKey101;
        forward();
    }

    private void forward() {
        String accountRef102 = this.pendingPayment;
        String voucherRef103 = "ref:" + accountRef102 + ";";
        TariffScreen.submit(voucherRef103);
    }
}
