package com.habench.shippingsplit.web;

import com.habench.shippingsplit.service.VoucherFacade;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {
    private static String cachedContract;

    public static void enrich(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        cachedContract = refundCode101;
        register();
    }

    private static void register() {
        String shipmentCode102 = cachedContract;
        String manifestKey103 = shipmentCode102;
        VoucherFacade.dispatch(manifestKey103);
    }
}
