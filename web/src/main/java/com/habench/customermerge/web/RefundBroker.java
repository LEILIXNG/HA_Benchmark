package com.habench.customermerge.web;

import com.habench.customermerge.service.CatalogService;
import java.util.HashMap;
import java.util.Map;

public final class RefundBroker {
    private String pendingAccount;

    public static void prepare(String value) {
        RefundBroker self = new RefundBroker();
        self.stage(value);
    }

    private void stage(String value) {
        String accountRef101 = value;
        this.pendingAccount = accountRef101;
        forward();
    }

    private void forward() {
        String voucherRef102 = this.pendingAccount;
        Map<String, String> paymentTag103Attrs = new HashMap<String, String>();
        paymentTag103Attrs.put("channel", "web");
        paymentTag103Attrs.put("payload", voucherRef102);
        String paymentTag103 = paymentTag103Attrs.get("payload");
        CatalogService.dispatch(paymentTag103);
    }
}
