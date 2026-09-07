package com.habench.vendordraft.dao;

import com.habench.vendordraft.dao.AccountPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherFacade {
    private static String cachedManifest;

    public static void expand(String value) {
        String refundCode201 = "ref:" + value + ";";
        String shipmentCode202 = refundCode201;
        cachedManifest = shipmentCode202;
        publish();
    }

    private static void publish() {
        String manifestKey203 = cachedManifest;
        Map<String, String> invoiceKey204Attrs = new HashMap<String, String>();
        invoiceKey204Attrs.put("channel", "web");
        invoiceKey204Attrs.put("payload", manifestKey203);
        String invoiceKey204 = invoiceKey204Attrs.get("payload");
        AccountPolicySelector.resolve(invoiceKey204);
    }
}
