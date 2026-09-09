package com.habench.pricingnotice.web;

import com.habench.pricingnotice.service.LedgerService;
import java.util.HashMap;
import java.util.Map;

public final class BatchResolver {
    private String pendingPayment;

    public static void merge(String value) {
        BatchResolver self = new BatchResolver();
        self.compose(value);
    }

    private void compose(String value) {
        String voucherRef101 = "ref:" + value + ";";
        String paymentTag102 = voucherRef101;
        this.pendingPayment = paymentTag102;
        assemble();
    }

    private void assemble() {
        String refundCode103 = this.pendingPayment;
        String shipmentCode104 = "ref:" + refundCode103 + ";";
        Map<String, String> manifestKey105Attrs = new HashMap<String, String>();
        manifestKey105Attrs.put("channel", "web");
        manifestKey105Attrs.put("payload", shipmentCode104);
        String manifestKey105 = manifestKey105Attrs.get("payload");
        LedgerService.compose(manifestKey105);
    }
}
