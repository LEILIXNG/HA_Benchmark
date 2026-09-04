package com.habench.path1025.web;

import com.habench.path1025.web.Handler01Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        String v1 = value;
        cached = v1;
        stage1();
    }

    private static void stage1() {
        String v2 = cached;
        Map<String, String> attrs3 = new HashMap<String, String>();
        attrs3.put("channel", "web");
        attrs3.put("payload", v2);
        String v3 = attrs3.get("payload");
        String v4 = "order:" + v3 + ";";
        cached = v4;
        stage2();
    }

    private static void stage2() {
        String v5 = cached;
        String v6 = "order:" + v5 + ";";
        String v7 = v6;
        cached = v7;
        stage3();
    }

    private static void stage3() {
        String v8 = cached;
        Map<String, String> attrs9 = new HashMap<String, String>();
        attrs9.put("channel", "web");
        attrs9.put("payload", v8);
        String v9 = attrs9.get("payload");
        String v10 = v9;
        Handler01Dispatcher.apply(v10);
    }
}
