package com.habench.cmdi1042.service;

import com.habench.cmdi1042.service.Sanitizer03;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {
    private static String cached;

    public static void handle(String value) {
        Map<String, String> attrs201 = new HashMap<String, String>();
        attrs201.put("channel", "web");
        attrs201.put("payload", value);
        String v201 = attrs201.get("payload");
        cached = v201;
        stage1();
    }

    private static void stage1() {
        String v202 = cached;
        Map<String, String> attrs203 = new HashMap<String, String>();
        attrs203.put("channel", "web");
        attrs203.put("payload", v202);
        String v203 = attrs203.get("payload");
        Map<String, String> attrs204 = new HashMap<String, String>();
        attrs204.put("channel", "web");
        attrs204.put("payload", v203);
        String v204 = attrs204.get("payload");
        cached = v204;
        stage2();
    }

    private static void stage2() {
        String v205 = cached;
        Map<String, String> attrs206 = new HashMap<String, String>();
        attrs206.put("channel", "web");
        attrs206.put("payload", v205);
        String v206 = attrs206.get("payload");
        Sanitizer03.apply(v206);
    }
}
