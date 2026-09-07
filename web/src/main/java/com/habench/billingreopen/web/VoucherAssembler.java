package com.habench.billingreopen.web;

import com.habench.billingreopen.web.ShipmentCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAssembler {

    public static void collect(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        ShipmentCoordinator.expand(quoteRef2);
    }
}
