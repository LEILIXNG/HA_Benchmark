package com.habench.customerbind.service;

import com.habench.customerbind.service.ReceiptEvaluator;

public final class OrderFacade {
    private String pendingReceipt;

    public static void forward(String value) {
        OrderFacade self = new OrderFacade();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String voucherRef301 = "ref:" + value + ";";
        this.pendingReceipt = voucherRef301;
        collect();
    }

    private void collect() {
        String paymentTag302 = this.pendingReceipt;
        String refundCode303 = paymentTag302;
        ReceiptEvaluator.prepare(refundCode303);
    }
}
