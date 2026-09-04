package com.habench.reportnotice.dao;

import com.habench.reportnotice.dao.TariffLoader;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBuilder {

    public static void route(String value) {
        Map<String, String> refundCode301Attrs = new HashMap<String, String>();
        refundCode301Attrs.put("channel", "web");
        refundCode301Attrs.put("payload", value);
        String refundCode301 = refundCode301Attrs.get("payload");
        String shipmentCode302 = "ref:" + refundCode301 + ";";
        TariffLoader.register(shipmentCode302);
    }
}
