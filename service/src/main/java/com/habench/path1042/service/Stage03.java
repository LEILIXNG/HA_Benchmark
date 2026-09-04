package com.habench.path1042.service;

import com.habench.path1042.service.Sanitizer04;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {
    private static String cached;

    public static void handle(String value) {
        Map<String, String> attrs301 = new HashMap<String, String>();
        attrs301.put("channel", "web");
        attrs301.put("payload", value);
        String v301 = attrs301.get("payload");
        cached = v301;
        stage1();
    }

    private static void stage1() {
        String v302 = cached;
        Map<String, String> attrs303 = new HashMap<String, String>();
        attrs303.put("channel", "web");
        attrs303.put("payload", v302);
        String v303 = attrs303.get("payload");
        Sanitizer04.apply(v303);
    }
}
