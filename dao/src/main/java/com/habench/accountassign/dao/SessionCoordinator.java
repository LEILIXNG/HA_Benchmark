package com.habench.accountassign.dao;

import com.habench.accountassign.dao.RefundBuilder;
import java.util.HashMap;
import java.util.Map;

public final class SessionCoordinator {
    private static String cachedManifest;

    public static void submit(String value) {
        String catalogKey301 = "ref:" + value + ";";
        String receiptKey302 = "ref:" + catalogKey301 + ";";
        cachedManifest = receiptKey302;
        prepare();
    }

    private static void prepare() {
        String accountRef303 = cachedManifest;
        String voucherRef304 = "ref:" + accountRef303 + ";";
        cachedManifest = voucherRef304;
        attach();
    }

    private static void attach() {
        String paymentTag305 = cachedManifest;
        Map<String, String> refundCode306Attrs = new HashMap<String, String>();
        refundCode306Attrs.put("channel", "web");
        refundCode306Attrs.put("payload", paymentTag305);
        String refundCode306 = refundCode306Attrs.get("payload");
        String shipmentCode307 = refundCode306;
        RefundBuilder.attach(shipmentCode307);
    }
}
