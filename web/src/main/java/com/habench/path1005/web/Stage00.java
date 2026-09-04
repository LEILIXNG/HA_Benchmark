package com.habench.path1005.web;

import com.habench.path1005.web.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        Map<String, String> attrs1 = new HashMap<String, String>();
        attrs1.put("channel", "web");
        attrs1.put("payload", value);
        String v1 = attrs1.get("payload");
        String v2 = v1;
        cached = v2;
        stage1();
    }

    private static void stage1() {
        String v3 = cached;
        String v4 = "order:" + v3 + ";";
        cached = v4;
        stage2();
    }

    private static void stage2() {
        String v5 = cached;
        Map<String, String> attrs6 = new HashMap<String, String>();
        attrs6.put("channel", "web");
        attrs6.put("payload", v5);
        String v6 = attrs6.get("payload");
        Stage01.apply(v6);
    }
}
