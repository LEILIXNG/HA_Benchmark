package com.habench.sqli1056n.web;

import com.habench.sqli1056n.web.Stage02;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {

    public static void handle(String value) {
        Map<String, String> attrs101 = new HashMap<String, String>();
        attrs101.put("channel", "web");
        attrs101.put("payload", value);
        String v101 = attrs101.get("payload");
        Stage02.handle(v101);
    }
}
