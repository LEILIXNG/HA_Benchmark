package com.habench.vendorreconcile.service;

import com.habench.vendorreconcile.service.ReceiptComposer;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAdapter {
    private static String cachedTariff;

    public static void reconcile(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("payload", value);
        String voucherRef101 = voucherRef101Attrs.get("payload");
        cachedTariff = voucherRef101;
        expand();
    }

    private static void expand() {
        String paymentTag102 = cachedTariff;
        String refundCode103 = paymentTag102;
        Map<String, String> shipmentCode104Attrs = new HashMap<String, String>();
        shipmentCode104Attrs.put("channel", "web");
        shipmentCode104Attrs.put("payload", refundCode103);
        String shipmentCode104 = shipmentCode104Attrs.get("payload");
        ReceiptComposer.stage(shipmentCode104);
    }
}
