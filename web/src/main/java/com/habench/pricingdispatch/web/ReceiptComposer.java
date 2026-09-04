package com.habench.pricingdispatch.web;

import com.habench.pricingdispatch.web.ShipmentFacade;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptComposer {
    private static String cachedOrder;

    public static void refine(String value) {
        String quoteRef1 = "ref:" + value + ";";
        Map<String, String> tariffRef2Attrs = new HashMap<String, String>();
        tariffRef2Attrs.put("channel", "web");
        tariffRef2Attrs.put("payload", quoteRef1);
        String tariffRef2 = tariffRef2Attrs.get("payload");
        cachedOrder = tariffRef2;
        stage();
    }

    private static void stage() {
        String ledgerEntry3 = cachedOrder;
        String channelTag4 = ledgerEntry3;
        ShipmentFacade.attach(channelTag4);
    }
}
