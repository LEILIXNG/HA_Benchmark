package com.habench.billingreview.web;

import com.habench.billingreview.service.LedgerFacade;
import java.util.HashMap;
import java.util.Map;

public final class ChannelAssembler {

    public static void refine(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        LedgerFacade.collect(orderRef1);
    }
}
