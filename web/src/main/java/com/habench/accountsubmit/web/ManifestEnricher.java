package com.habench.accountsubmit.web;

import com.habench.accountsubmit.service.ContractComposer;

public final class ManifestEnricher {
    private String pendingSession;

    public static void translate(String value) {
        ManifestEnricher self = new ManifestEnricher();
        self.prepare(value);
    }

    private void prepare(String value) {
        String paymentTag1 = "ref:" + value + ";";
        this.pendingSession = paymentTag1;
        forward();
    }

    private void forward() {
        String refundCode2 = this.pendingSession;
        String shipmentCode3 = "ref:" + refundCode2 + ";";
        ContractComposer.stage(shipmentCode3);
    }
}
