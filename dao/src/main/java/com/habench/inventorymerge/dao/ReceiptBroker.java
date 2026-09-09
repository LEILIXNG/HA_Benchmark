package com.habench.inventorymerge.dao;

import com.habench.inventorymerge.dao.OrderRepository;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptBroker {

    public static void forward(String value) {
        Map<String, String> orderRef501Attrs = new HashMap<String, String>();
        orderRef501Attrs.put("channel", "web");
        orderRef501Attrs.put("payload", value);
        String orderRef501 = orderRef501Attrs.get("payload");
        String quoteRef502 = "ref:" + orderRef501 + ";";
        OrderRepository.normalize(quoteRef502);
    }
}
