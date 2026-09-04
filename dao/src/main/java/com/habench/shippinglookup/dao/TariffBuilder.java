package com.habench.shippinglookup.dao;

import com.habench.shippinglookup.dao.ReceiptRepository;
import java.util.HashMap;
import java.util.Map;

public final class TariffBuilder {

    public static void route(String value) {
        Map<String, String> receiptKey401Attrs = new HashMap<String, String>();
        receiptKey401Attrs.put("channel", "web");
        receiptKey401Attrs.put("payload", value);
        String receiptKey401 = receiptKey401Attrs.get("payload");
        ReceiptRepository.merge(receiptKey401);
    }
}
