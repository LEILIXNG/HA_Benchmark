package com.habench.cmdi1032.web;

import com.habench.cmdi1032.service.Stage02;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private static String cached;

    public static void handle(String value) {
        Map<String, String> attrs101 = new HashMap<String, String>();
        attrs101.put("channel", "web");
        attrs101.put("payload", value);
        String v101 = attrs101.get("payload");
        cached = v101;
        stage1();
    }

    private static void stage1() {
        String v102 = cached;
        Map<String, String> attrs103 = new HashMap<String, String>();
        attrs103.put("channel", "web");
        attrs103.put("payload", v102);
        String v103 = attrs103.get("payload");
        cached = v103;
        stage2();
    }

    private static void stage2() {
        String v104 = cached;
        String v105 = v104;
        cached = v105;
        stage3();
    }

    private static void stage3() {
        String v106 = cached;
        String v107 = "order:" + v106 + ";";
        String v108 = "order:" + v107 + ";";
        Stage02.handle(v108);
    }
}
