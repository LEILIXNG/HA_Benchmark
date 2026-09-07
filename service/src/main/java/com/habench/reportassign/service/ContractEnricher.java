package com.habench.reportassign.service;

import com.habench.reportassign.service.VoucherEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ContractEnricher {

    public static void expand(String value) {
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("payload", value);
        String voucherRef201 = voucherRef201Attrs.get("payload");
        String paymentTag202 = voucherRef201;
        VoucherEvaluator.translate(paymentTag202);
    }
}
