package com.habench.path1005.service;

import com.habench.path1005.service.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {

    public static void handle(String value) {
        Map<String, String> attrs201 = new HashMap<String, String>();
        attrs201.put("channel", "web");
        attrs201.put("payload", value);
        String v201 = attrs201.get("payload");
        String v202 = "order:" + v201 + ";";
        SinkHandler.execute(v202);
    }
}
