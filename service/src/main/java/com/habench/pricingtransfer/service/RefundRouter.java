package com.habench.pricingtransfer.service;

import com.habench.pricingtransfer.service.TariffRuleSelector;

public final class RefundRouter {
    private String pendingSession;

    public static void register(String value) {
        RefundRouter self = new RefundRouter();
        self.refine(value);
    }

    private void refine(String value) {
        String paymentTag201 = value;
        String refundCode202 = "ref:" + paymentTag201 + ";";
        this.pendingSession = refundCode202;
        collect();
    }

    private void collect() {
        String shipmentCode203 = this.pendingSession;
        String manifestKey204 = shipmentCode203;
        this.pendingSession = manifestKey204;
        stage();
    }

    private void stage() {
        String invoiceKey205 = this.pendingSession;
        String batchTag206 = invoiceKey205;
        TariffRuleSelector.expand(batchTag206);
    }
}
