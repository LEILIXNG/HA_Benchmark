package com.habench.shippingmanifest.service;

import com.habench.shippingmanifest.dao.ManifestRouter;
import java.util.HashMap;
import java.util.Map;

public final class SessionBuilder {
    private static String cachedShipment;

    public static void refine(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        Map<String, String> accountRef202Attrs = new HashMap<String, String>();
        accountRef202Attrs.put("channel", "web");
        accountRef202Attrs.put("payload", receiptKey201);
        String accountRef202 = accountRef202Attrs.get("payload");
        cachedShipment = accountRef202;
        translate();
    }

    private static void translate() {
        String voucherRef203 = cachedShipment;
        String paymentTag204 = voucherRef203;
        Map<String, String> refundCode205Attrs = new HashMap<String, String>();
        refundCode205Attrs.put("channel", "web");
        refundCode205Attrs.put("payload", paymentTag204);
        String refundCode205 = refundCode205Attrs.get("payload");
        ManifestRouter.dispatch(refundCode205);
    }
}
