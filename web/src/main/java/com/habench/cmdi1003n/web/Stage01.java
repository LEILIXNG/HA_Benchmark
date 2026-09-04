package com.habench.cmdi1003n.web;

import com.habench.cmdi1003n.web.Sanitizer02;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {

    public static void handle(String value) {
        Map<String, String> attrs101 = new HashMap<String, String>();
        attrs101.put("channel", "web");
        attrs101.put("payload", value);
        String v101 = attrs101.get("payload");
        Sanitizer02.apply(v101);
    }
}
