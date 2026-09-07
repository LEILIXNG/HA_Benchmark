package com.habench.fulfilimport.service;

import com.habench.fulfilimport.dao.ChannelService;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCoordinator {

    public static void forward(String value) {
        String batchTag301 = "ref:" + value + ";";
        Map<String, String> orderRef302Attrs = new HashMap<String, String>();
        orderRef302Attrs.put("channel", "web");
        orderRef302Attrs.put("payload", batchTag301);
        String orderRef302 = orderRef302Attrs.get("payload");
        ChannelService.attach(orderRef302);
    }
}
