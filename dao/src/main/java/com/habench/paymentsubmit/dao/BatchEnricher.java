package com.habench.paymentsubmit.dao;

import com.habench.paymentsubmit.dao.LedgerService;
import java.util.HashMap;
import java.util.Map;

public final class BatchEnricher {

    public static void stage(String value) {
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("payload", value);
        String voucherRef201 = voucherRef201Attrs.get("payload");
        String paymentTag202 = voucherRef201;
        LedgerService.refine(paymentTag202);
    }
}
