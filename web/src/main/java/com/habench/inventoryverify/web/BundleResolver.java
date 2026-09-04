package com.habench.inventoryverify.web;

import com.habench.inventoryverify.web.ContractFacade;
import java.util.HashMap;
import java.util.Map;

public final class BundleResolver {

    public static void assemble(String value) {
        String voucherRef1 = "ref:" + value + ";";
        Map<String, String> paymentTag2Attrs = new HashMap<String, String>();
        paymentTag2Attrs.put("channel", "web");
        paymentTag2Attrs.put("payload", voucherRef1);
        String paymentTag2 = paymentTag2Attrs.get("payload");
        ContractFacade.stage(paymentTag2);
    }
}
