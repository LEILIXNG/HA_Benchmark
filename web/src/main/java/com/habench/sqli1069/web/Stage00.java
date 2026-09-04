package com.habench.sqli1069.web;

import com.habench.sqli1069.service.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        Map<String, String> attrs1 = new HashMap<String, String>();
        attrs1.put("channel", "web");
        attrs1.put("payload", value);
        String v1 = attrs1.get("payload");
        cached = v1;
        stage1();
    }

    private static void stage1() {
        String v2 = cached;
        String v3 = v2;
        String v4 = v3;
        Stage01.handle(v4);
    }
}
