package com.habench.paymentsettlequeue.web;

import com.habench.paymentsettlequeue.service.RefundBroker;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptComposer {

    public static void publish(String value) {
        String refundCode1 = "ref:" + value + ";";
        Map<String, String> shipmentCode2Attrs = new HashMap<String, String>();
        shipmentCode2Attrs.put("channel", "web");
        shipmentCode2Attrs.put("payload", refundCode1);
        String shipmentCode2 = shipmentCode2Attrs.get("payload");
        RefundBroker.assemble(shipmentCode2);
    }
}
