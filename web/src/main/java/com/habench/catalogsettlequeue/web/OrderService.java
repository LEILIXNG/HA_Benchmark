package com.habench.catalogsettlequeue.web;

import com.habench.catalogsettlequeue.service.ShipmentRouter;
import java.util.HashMap;
import java.util.Map;

public final class OrderService {
    private static String cachedRefund;

    public static void route(String value) {
        String paymentTag1 = "ref:" + value + ";";
        cachedRefund = paymentTag1;
        compose();
    }

    private static void compose() {
        String refundCode2 = cachedRefund;
        Map<String, String> shipmentCode3Attrs = new HashMap<String, String>();
        shipmentCode3Attrs.put("channel", "web");
        shipmentCode3Attrs.put("payload", refundCode2);
        String shipmentCode3 = shipmentCode3Attrs.get("payload");
        ShipmentRouter.assemble(shipmentCode3);
    }
}
