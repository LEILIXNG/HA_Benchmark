package com.habench.fulfilbind.web;

import com.habench.fulfilbind.web.VoucherStrategySelector;

public final class ManifestService {
    private String pendingLedger;
    private static String cachedLedger;

    public static void stage(String value) {
        ManifestService self = new ManifestService();
        self.prepare(value);
    }

    private void prepare(String value) {
        String accountRef1 = "ref:" + value + ";";
        String voucherRef2 = "ref:" + accountRef1 + ";";
        this.pendingLedger = voucherRef2;
        dispatch();
    }

    private void dispatch() {
        String paymentTag3 = this.pendingLedger;
        String refundCode4 = paymentTag3;
        String shipmentCode5 = refundCode4;
        cachedLedger = shipmentCode5;
        submit();
    }

    private void submit() {
        String manifestKey6 = cachedLedger;
        String invoiceKey7 = "ref:" + manifestKey6 + ";";
        VoucherStrategySelector.merge(invoiceKey7);
    }
}
