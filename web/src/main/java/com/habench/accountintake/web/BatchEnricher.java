package com.habench.accountintake.web;

import com.habench.accountintake.service.ChannelTranslator;
import java.util.HashMap;
import java.util.Map;

public final class BatchEnricher {

    public static void compose(String value) {
        String refundCode1 = "ref:" + value + ";";
        Map<String, String> shipmentCode2Attrs = new HashMap<String, String>();
        shipmentCode2Attrs.put("channel", "web");
        shipmentCode2Attrs.put("payload", refundCode1);
        String shipmentCode2 = shipmentCode2Attrs.get("payload");
        ChannelTranslator.translate(shipmentCode2);
    }
}
