package com.habench.sqli1049.web;

import com.habench.sqli1049.web.SinkHandler;
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
        Map<String, String> attrs3 = new HashMap<String, String>();
        attrs3.put("channel", "web");
        attrs3.put("payload", v2);
        String v3 = attrs3.get("payload");
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
        String v7 = v6;
        SinkHandler.execute(v7);
    }
}
