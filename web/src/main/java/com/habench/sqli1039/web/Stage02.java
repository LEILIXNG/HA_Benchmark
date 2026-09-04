package com.habench.sqli1039.web;

import com.habench.sqli1039.service.Stage03;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {
    private static String cached;

    public static void handle(String value) {
        Map<String, String> attrs201 = new HashMap<String, String>();
        attrs201.put("channel", "web");
        attrs201.put("payload", value);
        String v201 = attrs201.get("payload");
        String v202 = v201;
        cached = v202;
        stage1();
    }

    private static void stage1() {
        String v203 = cached;
        Map<String, String> attrs204 = new HashMap<String, String>();
        attrs204.put("channel", "web");
        attrs204.put("payload", v203);
        String v204 = attrs204.get("payload");
        Map<String, String> attrs205 = new HashMap<String, String>();
        attrs205.put("channel", "web");
        attrs205.put("payload", v204);
        String v205 = attrs205.get("payload");
        Stage03.handle(v205);
    }
}
