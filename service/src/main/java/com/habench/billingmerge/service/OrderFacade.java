package com.habench.billingmerge.service;

import com.habench.billingmerge.dao.ChannelRouter;
import java.util.HashMap;
import java.util.Map;

public final class OrderFacade {

    public static void resolve(String value) {
        Map<String, String> refundCode501Attrs = new HashMap<String, String>();
        refundCode501Attrs.put("channel", "web");
        refundCode501Attrs.put("payload", value);
        String refundCode501 = refundCode501Attrs.get("payload");
        String shipmentCode502 = refundCode501;
        ChannelRouter.register(shipmentCode502);
    }
}
