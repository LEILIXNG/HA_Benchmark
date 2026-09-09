package com.habench.paymentbatch.service;

import com.habench.paymentbatch.service.TariffRouter;
import java.util.HashMap;
import java.util.Map;

public final class RefundCoordinator {

    public static void translate(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("payload", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("payload");
        String channelTag102 = "ref:" + ledgerEntry101 + ";";
        TariffRouter.expand(channelTag102);
    }
}
