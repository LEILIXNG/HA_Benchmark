package com.habench.cmdi1030.web;

import com.habench.cmdi1030.web.Sanitizer01;
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
        String v3 = "order:" + v2 + ";";
        Map<String, String> attrs4 = new HashMap<String, String>();
        attrs4.put("channel", "web");
        attrs4.put("payload", v3);
        String v4 = attrs4.get("payload");
        cached = v4;
        stage2();
    }

    private static void stage2() {
        String v5 = cached;
        String v6 = "order:" + v5 + ";";
        Sanitizer01.apply(v6);
    }
}
