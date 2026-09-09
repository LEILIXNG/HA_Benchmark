package com.habench.reportledger.web;

import com.habench.reportledger.service.ChannelCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ChannelRegistry {
    private static String cachedVoucher;

    public static void prepare(String value) {
        String accountRef1 = "ref:" + value + ";";
        cachedVoucher = accountRef1;
        normalize();
    }

    private static void normalize() {
        String voucherRef2 = cachedVoucher;
        Map<String, String> paymentTag3Attrs = new HashMap<String, String>();
        paymentTag3Attrs.put("channel", "web");
        paymentTag3Attrs.put("payload", voucherRef2);
        String paymentTag3 = paymentTag3Attrs.get("payload");
        Map<String, String> refundCode4Attrs = new HashMap<String, String>();
        refundCode4Attrs.put("channel", "web");
        refundCode4Attrs.put("payload", paymentTag3);
        String refundCode4 = refundCode4Attrs.get("payload");
        ChannelCoordinator.compose(refundCode4);
    }
}
