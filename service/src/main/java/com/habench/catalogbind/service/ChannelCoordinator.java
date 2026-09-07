package com.habench.catalogbind.service;

import com.habench.catalogbind.dao.ShipmentRouter;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCoordinator {

    public static void merge(String value) {
        String quoteRef101 = "ref:" + value + ";";
        Map<String, String> tariffRef102Attrs = new HashMap<String, String>();
        tariffRef102Attrs.put("channel", "web");
        tariffRef102Attrs.put("payload", quoteRef101);
        String tariffRef102 = tariffRef102Attrs.get("payload");
        ShipmentRouter.forward(tariffRef102);
    }
}
