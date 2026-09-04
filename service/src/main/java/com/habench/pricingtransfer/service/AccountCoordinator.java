package com.habench.pricingtransfer.service;

import com.habench.pricingtransfer.service.SessionExecutor;
import java.util.HashMap;
import java.util.Map;

public final class AccountCoordinator {

    public static void publish(String value) {
        Map<String, String> batchTag401Attrs = new HashMap<String, String>();
        batchTag401Attrs.put("channel", "web");
        batchTag401Attrs.put("payload", value);
        String batchTag401 = batchTag401Attrs.get("payload");
        SessionExecutor.normalize(batchTag401);
    }
}
