package com.habench.pricingreconcile.dao;

import com.habench.pricingreconcile.dao.ShipmentPlan2Selector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelEnricher {

    public static void enrich(String value) {
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("payload", value);
        String voucherRef201 = voucherRef201Attrs.get("payload");
        String paymentTag202 = "ref:" + voucherRef201 + ";";
        ShipmentPlan2Selector.submit(paymentTag202);
    }
}
