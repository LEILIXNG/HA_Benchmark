package com.habench.cmdi1034.service;

import com.habench.cmdi1034.dao.Stage03;
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
        cached = v203;
        stage2();
    }

    private static void stage2() {
        String v204 = cached;
        Map<String, String> attrs205 = new HashMap<String, String>();
        attrs205.put("channel", "web");
        attrs205.put("payload", v204);
        String v205 = attrs205.get("payload");
        String v206 = v205;
        Stage03.handle(v206);
    }
}
