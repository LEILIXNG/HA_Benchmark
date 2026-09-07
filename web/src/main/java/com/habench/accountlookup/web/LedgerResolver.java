package com.habench.accountlookup.web;

import com.habench.accountlookup.service.ChannelResolver;

public final class LedgerResolver {
    private String pendingReceipt;

    public static void compose(String value) {
        LedgerResolver self = new LedgerResolver();
        self.collect(value);
    }

    private void collect(String value) {
        String voucherRef1 = value;
        String paymentTag2 = "ref:" + voucherRef1 + ";";
        this.pendingReceipt = paymentTag2;
        assemble();
    }

    private void assemble() {
        String refundCode3 = this.pendingReceipt;
        String shipmentCode4 = refundCode3;
        ChannelResolver.refine(shipmentCode4);
    }
}
