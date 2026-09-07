package com.habench.reportreopen.dao;

import com.habench.reportreopen.dao.BatchExecutor;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBroker {

    public static void normalize(String value) {
        Map<String, String> voucherRef401Attrs = new HashMap<String, String>();
        voucherRef401Attrs.put("channel", "web");
        voucherRef401Attrs.put("payload", value);
        String voucherRef401 = voucherRef401Attrs.get("payload");
        String paymentTag402 = voucherRef401;
        BatchExecutor.normalize(paymentTag402);
    }
}
