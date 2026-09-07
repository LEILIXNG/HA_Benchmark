package com.habench.inventoryrenewal.service;

import com.habench.inventoryrenewal.service.LedgerLoader;
import java.util.HashMap;
import java.util.Map;

public final class RefundCoordinator {
    private String pendingLedger;
    private static String cachedLedger;

    public static void forward(String value) {
        RefundCoordinator self = new RefundCoordinator();
        self.collect(value);
    }

    private void collect(String value) {
        String tariffRef101 = value;
        String ledgerEntry102 = "ref:" + tariffRef101 + ";";
        cachedLedger = ledgerEntry102;
        compose();
    }

    private void compose() {
        String channelTag103 = cachedLedger;
        String catalogKey104 = channelTag103;
        String receiptKey105 = "ref:" + catalogKey104 + ";";
        this.pendingLedger = receiptKey105;
        expand();
    }

    private void expand() {
        String accountRef106 = this.pendingLedger;
        String voucherRef107 = accountRef106;
        Map<String, String> paymentTag108Attrs = new HashMap<String, String>();
        paymentTag108Attrs.put("channel", "web");
        paymentTag108Attrs.put("payload", voucherRef107);
        String paymentTag108 = paymentTag108Attrs.get("payload");
        LedgerLoader.route(paymentTag108);
    }
}
