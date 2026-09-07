package com.habench.vendorrelease.dao;

import com.habench.vendorrelease.dao.RefundRepository;
import java.util.HashMap;
import java.util.Map;

public final class CatalogService {

    public static void translate(String value) {
        Map<String, String> catalogKey501Attrs = new HashMap<String, String>();
        catalogKey501Attrs.put("channel", "web");
        catalogKey501Attrs.put("payload", value);
        String catalogKey501 = catalogKey501Attrs.get("payload");
        String receiptKey502 = catalogKey501;
        RefundRepository.dispatch(receiptKey502);
    }
}
