package com.habench.sqli1061n.web;

import com.habench.sqli1061n.web.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        String v2 = v1;
        cached = v2;
        stage1();
    }

    private static void stage1() {
        String v3 = cached;
        Map<String, String> attrs4 = new HashMap<String, String>();
        attrs4.put("channel", "web");
        attrs4.put("payload", v3);
        String v4 = attrs4.get("payload");
        Map<String, String> attrs5 = new HashMap<String, String>();
        attrs5.put("channel", "web");
        attrs5.put("payload", v4);
        String v5 = attrs5.get("payload");
        Stage01.handle(v5);
    }
}
