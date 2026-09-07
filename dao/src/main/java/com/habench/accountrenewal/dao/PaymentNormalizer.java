package com.habench.accountrenewal.dao;

import com.habench.accountrenewal.dao.ContractEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class PaymentNormalizer {

    public static void attach(String value) {
        Map<String, String> shipmentCode401Attrs = new HashMap<String, String>();
        shipmentCode401Attrs.put("channel", "web");
        shipmentCode401Attrs.put("payload", value);
        String shipmentCode401 = shipmentCode401Attrs.get("payload");
        ContractEvaluator.compose(shipmentCode401);
    }
}
