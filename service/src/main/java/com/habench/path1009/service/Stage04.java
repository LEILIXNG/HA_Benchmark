package com.habench.path1009.service;

import com.habench.path1009.service.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage04 {

    public static void handle(String value) {
        Map<String, String> attrs401 = new HashMap<String, String>();
        attrs401.put("channel", "web");
        attrs401.put("payload", value);
        String v401 = attrs401.get("payload");
        SinkHandler.execute(v401);
    }
}
