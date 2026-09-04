package com.habench.sqli1041.service;

import com.habench.sqli1041.service.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private static String cached;

    public static void handle(String value) {
        String v101 = value;
        Map<String, String> attrs102 = new HashMap<String, String>();
        attrs102.put("channel", "web");
        attrs102.put("payload", v101);
        String v102 = attrs102.get("payload");
        cached = v102;
        stage1();
    }

    private static void stage1() {
        String v103 = cached;
        String v104 = "order:" + v103 + ";";
        cached = v104;
        stage2();
    }

    private static void stage2() {
        String v105 = cached;
        String v106 = v105;
        SinkHandler.execute(v106);
    }
}
