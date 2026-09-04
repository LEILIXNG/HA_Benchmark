package com.habench.fulfildispatch.dao;

import com.habench.fulfildispatch.dao.BundleRouter;
import java.util.HashMap;
import java.util.Map;

public final class RefundFacade {

    public static void prepare(String value) {
        Map<String, String> shipmentCode201Attrs = new HashMap<String, String>();
        shipmentCode201Attrs.put("channel", "web");
        shipmentCode201Attrs.put("payload", value);
        String shipmentCode201 = shipmentCode201Attrs.get("payload");
        BundleRouter.assemble(shipmentCode201);
    }
}
