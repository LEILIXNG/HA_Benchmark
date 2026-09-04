package com.habench.sqli1045.web;

import com.habench.sqli1045.service.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = value;
        Map<String, String> attrs2 = new HashMap<String, String>();
        attrs2.put("channel", "web");
        attrs2.put("payload", v1);
        String v2 = attrs2.get("payload");
        Stage01.apply(v2);
    }
}
