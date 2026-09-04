package com.habench.sqli1064.web;

import com.habench.sqli1064.web.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        String v1 = value;
        String v2 = v1;
        cached = v2;
        stage1();
    }

    private static void stage1() {
        String v3 = cached;
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
        SinkHandler.execute(v6);
    }
}
