package com.habench.paymentbind.web;

import com.habench.paymentbind.service.ContractScreen;
import java.util.HashMap;
import java.util.Map;

public final class BundleComposer {
    private static String cachedSession;

    public static void merge(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        String manifestKey2 = shipmentCode1;
        cachedSession = manifestKey2;
        expand();
    }

    private static void expand() {
        String invoiceKey3 = cachedSession;
        String batchTag4 = "ref:" + invoiceKey3 + ";";
        ContractScreen.resolve(batchTag4);
    }
}
