package com.habench.catalogrenewal.web;

import com.habench.catalogrenewal.service.BundleComposer;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceRouter {

    public static void dispatch(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        String paymentTag2 = "ref:" + voucherRef1 + ";";
        BundleComposer.assemble(paymentTag2);
    }
}
