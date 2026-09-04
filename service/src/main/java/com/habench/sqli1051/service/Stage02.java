package com.habench.sqli1051.service;

import com.habench.sqli1051.service.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {

    public static void handle(String value) {
        Map<String, String> attrs201 = new HashMap<String, String>();
        attrs201.put("channel", "web");
        attrs201.put("payload", value);
        String v201 = attrs201.get("payload");
        SinkHandler.execute(v201);
    }
}
