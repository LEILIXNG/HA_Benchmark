package com.habench.vendorreopen.web;

import com.habench.vendorreopen.service.SessionCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class SessionService {
    private static String cachedAccount;

    public static void compose(String value) {
        String voucherRef1 = "ref:" + value + ";";
        Map<String, String> paymentTag2Attrs = new HashMap<String, String>();
        paymentTag2Attrs.put("channel", "web");
        paymentTag2Attrs.put("payload", voucherRef1);
        String paymentTag2 = paymentTag2Attrs.get("payload");
        cachedAccount = paymentTag2;
        normalize();
    }

    private static void normalize() {
        String refundCode3 = cachedAccount;
        String shipmentCode4 = "ref:" + refundCode3 + ";";
        SessionCoordinator.resolve(shipmentCode4);
    }
}
