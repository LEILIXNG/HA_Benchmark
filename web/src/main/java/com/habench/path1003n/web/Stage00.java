package com.habench.path1003n.web;

import com.habench.path1003n.service.Sanitizer01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = value;
        Map<String, String> attrs2 = new HashMap<String, String>();
        attrs2.put("channel", "web");
        attrs2.put("payload", v1);
        String v2 = attrs2.get("payload");
        Sanitizer01.apply(v2);
    }
}
