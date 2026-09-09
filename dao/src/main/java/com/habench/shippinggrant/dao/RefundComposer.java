package com.habench.shippinggrant.dao;

import com.habench.shippinggrant.dao.ShipmentAdapter;
import java.util.HashMap;
import java.util.Map;

public final class RefundComposer {

    public static void translate(String value) {
        Map<String, String> voucherRef401Attrs = new HashMap<String, String>();
        voucherRef401Attrs.put("channel", "web");
        voucherRef401Attrs.put("payload", value);
        String voucherRef401 = voucherRef401Attrs.get("payload");
        String paymentTag402 = "ref:" + voucherRef401 + ";";
        ShipmentAdapter.refine(paymentTag402);
    }
}
