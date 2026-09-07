package com.habench.pricingbind.dao;

import com.habench.pricingbind.dao.ReceiptRepository;
import java.util.HashMap;
import java.util.Map;

public final class AccountRouter {

    public static void translate(String value) {
        Map<String, String> refundCode401Attrs = new HashMap<String, String>();
        refundCode401Attrs.put("channel", "web");
        refundCode401Attrs.put("payload", value);
        String refundCode401 = refundCode401Attrs.get("payload");
        String shipmentCode402 = "ref:" + refundCode401 + ";";
        ReceiptRepository.normalize(shipmentCode402);
    }
}
