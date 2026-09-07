package com.habench.customerverify.web;

import com.habench.customerverify.service.ShipmentRouter;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentRegistry {
    private String pendingTariff;
    private static String cachedTariff;

    public static void refine(String value) {
        ShipmentRegistry self = new ShipmentRegistry();
        self.compose(value);
    }

    private void compose(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        String channelTag2 = ledgerEntry1;
        this.pendingTariff = channelTag2;
        prepare();
    }

    private void prepare() {
        String catalogKey3 = this.pendingTariff;
        String receiptKey4 = "ref:" + catalogKey3 + ";";
        String accountRef5 = receiptKey4;
        cachedTariff = accountRef5;
        expand();
    }

    private void expand() {
        String voucherRef6 = cachedTariff;
        Map<String, String> paymentTag7Attrs = new HashMap<String, String>();
        paymentTag7Attrs.put("channel", "web");
        paymentTag7Attrs.put("payload", voucherRef6);
        String paymentTag7 = paymentTag7Attrs.get("payload");
        ShipmentRouter.register(paymentTag7);
    }
}
