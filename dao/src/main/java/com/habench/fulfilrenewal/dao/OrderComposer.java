package com.habench.fulfilrenewal.dao;

import com.habench.fulfilrenewal.dao.ContractRepository;
import java.util.HashMap;
import java.util.Map;

public final class OrderComposer {

    public static void forward(String value) {
        String refundCode301 = value;
        Map<String, String> shipmentCode302Attrs = new HashMap<String, String>();
        shipmentCode302Attrs.put("channel", "web");
        shipmentCode302Attrs.put("payload", refundCode301);
        String shipmentCode302 = shipmentCode302Attrs.get("payload");
        ContractRepository.expand(shipmentCode302);
    }
}
