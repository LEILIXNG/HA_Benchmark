package com.habench.shippingrollup.web;

import com.habench.shippingrollup.service.RefundRouter;
import java.util.HashMap;
import java.util.Map;

public final class AccountComposer {
    private static String cachedShipment;

    public static void attach(String value) {
        String batchTag1 = "ref:" + value + ";";
        Map<String, String> orderRef2Attrs = new HashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("payload", batchTag1);
        String orderRef2 = orderRef2Attrs.get("payload");
        cachedShipment = orderRef2;
        prepare();
    }

    private static void prepare() {
        String quoteRef3 = cachedShipment;
        String tariffRef4 = quoteRef3;
        cachedShipment = tariffRef4;
        translate();
    }

    private static void translate() {
        String ledgerEntry5 = cachedShipment;
        String channelTag6 = ledgerEntry5;
        RefundRouter.stage(channelTag6);
    }
}
