package com.habench.sqli1056.service;

import com.habench.sqli1056.service.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage05 {

    public static void handle(String value) {
        Map<String, String> attrs501 = new HashMap<String, String>();
        attrs501.put("channel", "web");
        attrs501.put("payload", value);
        String v501 = attrs501.get("payload");
        Map<String, String> attrs502 = new HashMap<String, String>();
        attrs502.put("channel", "web");
        attrs502.put("payload", v501);
        String v502 = attrs502.get("payload");
        SinkHandler.execute(v502);
    }
}
