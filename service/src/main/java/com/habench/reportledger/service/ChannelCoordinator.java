package com.habench.reportledger.service;

import com.habench.reportledger.service.VoucherPolicy;

public final class ChannelCoordinator {
    private String pendingVoucher;

    public static void compose(String value) {
        ChannelCoordinator self = new ChannelCoordinator();
        self.refine(value);
    }

    private void refine(String value) {
        String tariffRef101 = value;
        this.pendingVoucher = tariffRef101;
        normalize();
    }

    private void normalize() {
        String ledgerEntry102 = this.pendingVoucher;
        String channelTag103 = "ref:" + ledgerEntry102 + ";";
        String catalogKey104 = "ref:" + channelTag103 + ";";
        VoucherPolicy.publish(catalogKey104);
    }
}
