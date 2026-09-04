package com.habench.sqli1040n.web;

import com.habench.sqli1040n.web.Handler02Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private static String cached;

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        String v102 = "order:" + v101 + ";";
        cached = v102;
        stage1();
    }

    private static void stage1() {
        String v103 = cached;
        String v104 = "order:" + v103 + ";";
        String v105 = v104;
        cached = v105;
        stage2();
    }

    private static void stage2() {
        String v106 = cached;
        Map<String, String> attrs107 = new HashMap<String, String>();
        attrs107.put("channel", "web");
        attrs107.put("payload", v106);
        String v107 = attrs107.get("payload");
        Map<String, String> attrs108 = new HashMap<String, String>();
        attrs108.put("channel", "web");
        attrs108.put("payload", v107);
        String v108 = attrs108.get("payload");
        Handler02Dispatcher.apply(v108);
    }
}
