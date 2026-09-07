package com.habench.shippingarchive.service;

import com.habench.shippingarchive.service.LedgerGuard;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCoordinator {
    private String pendingSession;

    public static void assemble(String value) {
        ShipmentCoordinator self = new ShipmentCoordinator();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String receiptKey101 = "ref:" + value + ";";
        Map<String, String> accountRef102Attrs = new HashMap<String, String>();
        accountRef102Attrs.put("channel", "web");
        accountRef102Attrs.put("payload", receiptKey101);
        String accountRef102 = accountRef102Attrs.get("payload");
        this.pendingSession = accountRef102;
        publish();
    }

    private void publish() {
        String voucherRef103 = this.pendingSession;
        String paymentTag104 = voucherRef103;
        LedgerGuard.resolve(paymentTag104);
    }
}
