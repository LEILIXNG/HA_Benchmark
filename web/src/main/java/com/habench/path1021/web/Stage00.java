package com.habench.path1021.web;

import com.habench.path1021.web.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        String v2 = "order:" + v1 + ";";
        cached = v2;
        stage1();
    }

    private static void stage1() {
        String v3 = cached;
        Map<String, String> attrs4 = new HashMap<String, String>();
        attrs4.put("channel", "web");
        attrs4.put("payload", v3);
        String v4 = attrs4.get("payload");
        String v5 = "order:" + v4 + ";";
        Stage01.handle(v5);
    }
}
