package com.habench.accounttransfer.service;

import com.habench.accounttransfer.service.RefundRouter;
import java.util.HashMap;
import java.util.Map;

public final class SessionAdapter {

    public static void route(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        Map<String, String> shipmentCode102Attrs = new HashMap<String, String>();
        shipmentCode102Attrs.put("channel", "web");
        shipmentCode102Attrs.put("payload", refundCode101);
        String shipmentCode102 = shipmentCode102Attrs.get("payload");
        RefundRouter.refine(shipmentCode102);
    }
}
