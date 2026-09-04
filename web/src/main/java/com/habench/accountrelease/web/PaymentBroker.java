package com.habench.accountrelease.web;

import com.habench.accountrelease.service.TariffCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBroker {
    private static String cachedRefund;

    public static void reconcile(String value) {
        String catalogKey1 = "ref:" + value + ";";
        cachedRefund = catalogKey1;
        dispatch();
    }

    private static void dispatch() {
        String receiptKey2 = cachedRefund;
        String accountRef3 = receiptKey2;
        Map<String, String> voucherRef4Attrs = new HashMap<String, String>();
        voucherRef4Attrs.put("channel", "web");
        voucherRef4Attrs.put("payload", accountRef3);
        String voucherRef4 = voucherRef4Attrs.get("payload");
        TariffCoordinator.assemble(voucherRef4);
    }
}
