package com.habench.vendorbind.dao;

import com.habench.vendorbind.dao.RefundExecutor;
import java.util.HashMap;
import java.util.Map;

public final class BatchTranslator {

    public static void stage(String value) {
        String refundCode201 = value;
        Map<String, String> shipmentCode202Attrs = new HashMap<String, String>();
        shipmentCode202Attrs.put("channel", "web");
        shipmentCode202Attrs.put("payload", refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.get("payload");
        RefundExecutor.translate(shipmentCode202);
    }
}
