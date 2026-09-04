package com.habench.sqli1056n.service;

import com.habench.sqli1056n.service.Sanitizer06;
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
        Sanitizer06.apply(v502);
    }
}
