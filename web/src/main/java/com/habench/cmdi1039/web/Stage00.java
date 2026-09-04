package com.habench.cmdi1039.web;

import com.habench.cmdi1039.service.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
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
        cached = v6;
        stage3();
    }

    private static void stage3() {
        String v7 = cached;
        String v8 = "order:" + v7 + ";";
        String v9 = "order:" + v8 + ";";
        Stage01.handle(v9);
    }
}
