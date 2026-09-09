package com.habench.catalogdigest.dao;

import com.habench.catalogdigest.dao.VoucherGuard;
import java.util.HashMap;
import java.util.Map;

public final class ContractEnricher {

    public static void prepare(String value) {
        Map<String, String> refundCode401Attrs = new HashMap<String, String>();
        refundCode401Attrs.put("channel", "web");
        refundCode401Attrs.put("payload", value);
        String refundCode401 = refundCode401Attrs.get("payload");
        Map<String, String> shipmentCode402Attrs = new HashMap<String, String>();
        shipmentCode402Attrs.put("channel", "web");
        shipmentCode402Attrs.put("payload", refundCode401);
        String shipmentCode402 = shipmentCode402Attrs.get("payload");
        VoucherGuard.forward(shipmentCode402);
    }
}
