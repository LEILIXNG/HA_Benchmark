package com.habench.accounttransfer.dao;

import com.habench.accounttransfer.dao.QuoteValidator;
import java.util.HashMap;
import java.util.Map;

public final class RefundRouter {

    public static void refine(String value) {
        String refundCode401 = value;
        Map<String, String> shipmentCode402Attrs = new HashMap<String, String>();
        shipmentCode402Attrs.put("channel", "web");
        shipmentCode402Attrs.put("payload", refundCode401);
        String shipmentCode402 = shipmentCode402Attrs.get("payload");
        QuoteValidator.assemble(shipmentCode402);
    }
}
