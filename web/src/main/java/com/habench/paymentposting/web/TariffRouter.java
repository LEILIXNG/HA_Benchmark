package com.habench.paymentposting.web;

import com.habench.paymentposting.service.InvoiceEnricher;
import java.util.HashMap;
import java.util.Map;

public final class TariffRouter {

    public static void publish(String value) {
        Map<String, String> tariffRef201Attrs = new HashMap<String, String>();
        tariffRef201Attrs.put("channel", "web");
        tariffRef201Attrs.put("payload", value);
        String tariffRef201 = tariffRef201Attrs.get("payload");
        InvoiceEnricher.assemble(tariffRef201);
    }
}
