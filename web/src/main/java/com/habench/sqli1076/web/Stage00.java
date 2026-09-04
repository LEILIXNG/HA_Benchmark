package com.habench.sqli1076.web;

import com.habench.sqli1076.web.Handler01Dispatcher;
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
        Map<String, String> attrs4 = new HashMap<String, String>();
        attrs4.put("channel", "web");
        attrs4.put("payload", v3);
        String v4 = attrs4.get("payload");
        String v5 = v4;
        Handler01Dispatcher.apply(v5);
    }
}
