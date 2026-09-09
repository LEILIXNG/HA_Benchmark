package com.habench.billingsplit.service;

import com.habench.billingsplit.service.ChannelFacade;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBroker {

    public static void register(String value) {
        String shipmentCode301 = "ref:" + value + ";";
        Map<String, String> manifestKey302Attrs = new HashMap<String, String>();
        manifestKey302Attrs.put("channel", "web");
        manifestKey302Attrs.put("payload", shipmentCode301);
        String manifestKey302 = manifestKey302Attrs.get("payload");
        ChannelFacade.route(manifestKey302);
    }
}
