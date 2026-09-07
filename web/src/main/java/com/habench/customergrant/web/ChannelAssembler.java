package com.habench.customergrant.web;

import com.habench.customergrant.service.BundleTranslator;
import java.util.HashMap;
import java.util.Map;

public final class ChannelAssembler {
    private static String cachedChannel;

    public static void forward(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        cachedChannel = voucherRef1;
        refine();
    }

    private static void refine() {
        String paymentTag2 = cachedChannel;
        String refundCode3 = "ref:" + paymentTag2 + ";";
        String shipmentCode4 = refundCode3;
        BundleTranslator.route(shipmentCode4);
    }
}
