package com.habench.cmdi1034.web;

import com.habench.cmdi1034.web.Handler01Dispatcher;
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
        cached = v3;
        stage2();
    }

    private static void stage2() {
        String v4 = cached;
        Map<String, String> attrs5 = new HashMap<String, String>();
        attrs5.put("channel", "web");
        attrs5.put("payload", v4);
        String v5 = attrs5.get("payload");
        Handler01Dispatcher.apply(v5);
    }
}
