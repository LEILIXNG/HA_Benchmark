package com.habench.vendorsplit.dao;

import com.habench.vendorsplit.dao.RefundLoader;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptService {

    public static void compose(String value) {
        String voucherRef401 = value;
        Map<String, String> paymentTag402Attrs = new HashMap<String, String>();
        paymentTag402Attrs.put("channel", "web");
        paymentTag402Attrs.put("payload", voucherRef401);
        String paymentTag402 = paymentTag402Attrs.get("payload");
        RefundLoader.forward(paymentTag402);
    }
}
