package com.habench.billinggrant.web;

import com.habench.billinggrant.web.RefundCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class OrderResolver {
    private static String cachedChannel;

    public static void expand(String value) {
        String accountRef1 = "ref:" + value + ";";
        String voucherRef2 = accountRef1;
        cachedChannel = voucherRef2;
        resolve();
    }

    private static void resolve() {
        String paymentTag3 = cachedChannel;
        Map<String, String> refundCode4Attrs = new HashMap<String, String>();
        refundCode4Attrs.put("channel", "web");
        refundCode4Attrs.put("payload", paymentTag3);
        String refundCode4 = refundCode4Attrs.get("payload");
        Map<String, String> shipmentCode5Attrs = new HashMap<String, String>();
        shipmentCode5Attrs.put("channel", "web");
        shipmentCode5Attrs.put("payload", refundCode4);
        String shipmentCode5 = shipmentCode5Attrs.get("payload");
        RefundCoordinator.register(shipmentCode5);
    }
}
