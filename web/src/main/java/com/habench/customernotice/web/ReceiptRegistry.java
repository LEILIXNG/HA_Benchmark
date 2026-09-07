package com.habench.customernotice.web;

import com.habench.customernotice.web.VoucherScreen;

public final class ReceiptRegistry {
    private String pendingRefund;

    public static void forward(String value) {
        ReceiptRegistry self = new ReceiptRegistry();
        self.compose(value);
    }

    private void compose(String value) {
        String receiptKey1 = value;
        this.pendingRefund = receiptKey1;
        normalize();
    }

    private void normalize() {
        String accountRef2 = this.pendingRefund;
        String voucherRef3 = accountRef2;
        String paymentTag4 = "ref:" + voucherRef3 + ";";
        VoucherScreen.expand(paymentTag4);
    }
}
