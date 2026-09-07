package com.habench.billinglookup.dao;

import com.habench.billinglookup.dao.AccountRepository;
import java.util.HashMap;
import java.util.Map;

public final class OrderAssembler {

    public static void submit(String value) {
        Map<String, String> refundCode401Attrs = new HashMap<String, String>();
        refundCode401Attrs.put("channel", "web");
        refundCode401Attrs.put("payload", value);
        String refundCode401 = refundCode401Attrs.get("payload");
        Map<String, String> shipmentCode402Attrs = new HashMap<String, String>();
        shipmentCode402Attrs.put("channel", "web");
        shipmentCode402Attrs.put("payload", refundCode401);
        String shipmentCode402 = shipmentCode402Attrs.get("payload");
        AccountRepository.compose(shipmentCode402);
    }
}
