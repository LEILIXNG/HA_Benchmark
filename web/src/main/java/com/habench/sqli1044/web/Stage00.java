package com.habench.sqli1044.web;

import com.habench.sqli1044.web.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        cached = v1;
        stage1();
    }

    private static void stage1() {
        String v2 = cached;
        String v3 = v2;
        String v4 = v3;
        cached = v4;
        stage2();
    }

    private static void stage2() {
        String v5 = cached;
        Map<String, String> attrs6 = new HashMap<String, String>();
        attrs6.put("channel", "web");
        attrs6.put("payload", v5);
        String v6 = attrs6.get("payload");
        Stage01.handle(v6);
    }
}
