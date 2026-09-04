package com.habench.cmdi1049.web;

import com.habench.cmdi1049.service.Sanitizer01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        Map<String, String> attrs1 = new HashMap<String, String>();
        attrs1.put("channel", "web");
        attrs1.put("payload", value);
        String v1 = attrs1.get("payload");
        Map<String, String> attrs2 = new HashMap<String, String>();
        attrs2.put("channel", "web");
        attrs2.put("payload", v1);
        String v2 = attrs2.get("payload");
        cached = v2;
        stage1();
    }

    private static void stage1() {
        String v3 = cached;
        String v4 = "order:" + v3 + ";";
        Sanitizer01.apply(v4);
    }
}
