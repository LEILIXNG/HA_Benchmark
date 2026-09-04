package com.habench.inventorydraft.service;

import com.habench.inventorydraft.service.AccountService;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRegistry {
    private String pendingShipment;
    private static String cachedShipment;

    public static void collect(String value) {
        VoucherRegistry self = new VoucherRegistry();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        Map<String, String> receiptKey101Attrs = new HashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("payload", value);
        String receiptKey101 = receiptKey101Attrs.get("payload");
        String accountRef102 = receiptKey101;
        this.pendingShipment = accountRef102;
        forward();
    }

    private void forward() {
        String voucherRef103 = this.pendingShipment;
        Map<String, String> paymentTag104Attrs = new HashMap<String, String>();
        paymentTag104Attrs.put("channel", "web");
        paymentTag104Attrs.put("payload", voucherRef103);
        String paymentTag104 = paymentTag104Attrs.get("payload");
        cachedShipment = paymentTag104;
        resolve();
    }

    private void resolve() {
        String refundCode105 = cachedShipment;
        String shipmentCode106 = refundCode105;
        AccountService.merge(shipmentCode106);
    }
}
