package com.habench.customercapture.service;

import com.habench.customercapture.dao.VoucherRouter;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentAdapter {
    private static String cachedAccount;

    public static void forward(String value) {
        String shipmentCode101 = value;
        cachedAccount = shipmentCode101;
        compose();
    }

    private static void compose() {
        String manifestKey102 = cachedAccount;
        Map<String, String> invoiceKey103Attrs = new HashMap<String, String>();
        invoiceKey103Attrs.put("channel", "web");
        invoiceKey103Attrs.put("payload", manifestKey102);
        String invoiceKey103 = invoiceKey103Attrs.get("payload");
        VoucherRouter.attach(invoiceKey103);
    }
}
