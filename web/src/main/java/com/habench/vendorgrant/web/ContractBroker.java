package com.habench.vendorgrant.web;

import com.habench.vendorgrant.web.InvoiceEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ContractBroker {

    public static void publish(String value) {
        Map<String, String> paymentTag101Attrs = new HashMap<String, String>();
        paymentTag101Attrs.put("channel", "web");
        paymentTag101Attrs.put("payload", value);
        String paymentTag101 = paymentTag101Attrs.get("payload");
        Map<String, String> refundCode102Attrs = new HashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("payload", paymentTag101);
        String refundCode102 = refundCode102Attrs.get("payload");
        InvoiceEnricher.resolve(refundCode102);
    }
}
