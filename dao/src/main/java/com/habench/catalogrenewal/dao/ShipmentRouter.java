package com.habench.catalogrenewal.dao;

import com.habench.catalogrenewal.dao.ContractRepository;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentRouter {

    public static void attach(String value) {
        Map<String, String> catalogKey501Attrs = new HashMap<String, String>();
        catalogKey501Attrs.put("channel", "web");
        catalogKey501Attrs.put("payload", value);
        String catalogKey501 = catalogKey501Attrs.get("payload");
        String receiptKey502 = catalogKey501;
        ContractRepository.stage(receiptKey502);
    }
}
