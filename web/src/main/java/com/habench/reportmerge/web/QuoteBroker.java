package com.habench.reportmerge.web;

import com.habench.reportmerge.service.ShipmentEnricher;
import java.util.HashMap;
import java.util.Map;

public final class QuoteBroker {
    private String pendingContract;

    public static void route(String value) {
        QuoteBroker self = new QuoteBroker();
        self.resolve(value);
    }

    private void resolve(String value) {
        String receiptKey1 = value;
        this.pendingContract = receiptKey1;
        forward();
    }

    private void forward() {
        String accountRef2 = this.pendingContract;
        Map<String, String> voucherRef3Attrs = new HashMap<String, String>();
        voucherRef3Attrs.put("channel", "web");
        voucherRef3Attrs.put("payload", accountRef2);
        String voucherRef3 = voucherRef3Attrs.get("payload");
        String paymentTag4 = voucherRef3;
        ShipmentEnricher.resolve(paymentTag4);
    }
}
