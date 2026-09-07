package com.habench.pricinggrant.service;

import com.habench.pricinggrant.service.AccountResolver;
import java.util.HashMap;
import java.util.Map;

public final class ChannelService {
    private static String cachedAccount;

    public static void submit(String value) {
        Map<String, String> refundCode301Attrs = new HashMap<String, String>();
        refundCode301Attrs.put("channel", "web");
        refundCode301Attrs.put("payload", value);
        String refundCode301 = refundCode301Attrs.get("payload");
        String shipmentCode302 = "ref:" + refundCode301 + ";";
        cachedAccount = shipmentCode302;
        expand();
    }

    private static void expand() {
        String manifestKey303 = cachedAccount;
        String invoiceKey304 = manifestKey303;
        cachedAccount = invoiceKey304;
        stage();
    }

    private static void stage() {
        String batchTag305 = cachedAccount;
        Map<String, String> orderRef306Attrs = new HashMap<String, String>();
        orderRef306Attrs.put("channel", "web");
        orderRef306Attrs.put("payload", batchTag305);
        String orderRef306 = orderRef306Attrs.get("payload");
        AccountResolver.reconcile(orderRef306);
    }
}
