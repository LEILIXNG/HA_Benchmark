package com.habench.reportsettle.web;

import com.habench.reportsettle.service.QuoteCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ContractFacade {

    public static void forward(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        String paymentTag2 = "ref:" + voucherRef1 + ";";
        QuoteCoordinator.translate(paymentTag2);
    }
}
