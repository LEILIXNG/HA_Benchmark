package com.habench.billingsettlequeue.web;

import com.habench.billingsettlequeue.service.InvoiceAssembler;
import java.util.HashMap;
import java.util.Map;

public final class PaymentTranslator {

    public static void merge(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("payload", value);
        String shipmentCode101 = shipmentCode101Attrs.get("payload");
        InvoiceAssembler.publish(shipmentCode101);
    }
}
