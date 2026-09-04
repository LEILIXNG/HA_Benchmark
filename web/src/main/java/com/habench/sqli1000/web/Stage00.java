package com.habench.sqli1000.web;

import com.habench.sqli1000.service.Sanitizer01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {

    public static void handle(String value) {
        Map<String, String> attrs1 = new HashMap<String, String>();
        attrs1.put("channel", "web");
        attrs1.put("payload", value);
        String v1 = attrs1.get("payload");
        Sanitizer01.apply(v1);
    }
}
