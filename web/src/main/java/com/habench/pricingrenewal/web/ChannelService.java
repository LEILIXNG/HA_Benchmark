package com.habench.pricingrenewal.web;

import com.habench.pricingrenewal.web.BatchPlanSelector;

public final class ChannelService {
    private String pendingSession;

    public static void translate(String value) {
        ChannelService self = new ChannelService();
        self.forward(value);
    }

    private void forward(String value) {
        String accountRef101 = "ref:" + value + ";";
        String voucherRef102 = accountRef101;
        this.pendingSession = voucherRef102;
        compose();
    }

    private void compose() {
        String paymentTag103 = this.pendingSession;
        String refundCode104 = paymentTag103;
        BatchPlanSelector.reconcile(refundCode104);
    }
}
