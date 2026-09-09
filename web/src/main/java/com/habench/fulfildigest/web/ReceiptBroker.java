package com.habench.fulfildigest.web;

import com.habench.fulfildigest.service.ContractService;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptBroker {

    public static void prepare(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        String quoteRef2 = orderRef1;
        ContractService.forward(quoteRef2);
    }
}
