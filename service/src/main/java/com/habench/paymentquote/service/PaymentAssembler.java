package com.habench.paymentquote.service;

import com.habench.paymentquote.dao.TariffEnricher;
import java.util.HashMap;
import java.util.Map;

public final class PaymentAssembler {

    public static void merge(String value) {
        String refundCode301 = value;
        Map<String, String> shipmentCode302Attrs = new HashMap<String, String>();
        shipmentCode302Attrs.put("channel", "web");
        shipmentCode302Attrs.put("payload", refundCode301);
        String shipmentCode302 = shipmentCode302Attrs.get("payload");
        TariffEnricher.submit(shipmentCode302);
    }
}
