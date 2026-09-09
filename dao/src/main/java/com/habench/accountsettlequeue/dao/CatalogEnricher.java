package com.habench.accountsettlequeue.dao;

import com.habench.accountsettlequeue.dao.RefundRepository;
import java.util.HashMap;
import java.util.Map;

public final class CatalogEnricher {

    public static void submit(String value) {
        Map<String, String> tariffRef401Attrs = new HashMap<String, String>();
        tariffRef401Attrs.put("channel", "web");
        tariffRef401Attrs.put("payload", value);
        String tariffRef401 = tariffRef401Attrs.get("payload");
        RefundRepository.merge(tariffRef401);
    }
}
