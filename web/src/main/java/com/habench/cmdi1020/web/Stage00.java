package com.habench.cmdi1020.web;

import com.habench.cmdi1020.service.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        Map<String, String> attrs1 = new HashMap<String, String>();
        attrs1.put("channel", "web");
        attrs1.put("payload", value);
        String v1 = attrs1.get("payload");
        String v2 = "order:" + v1 + ";";
        cached = v2;
        stage1();
    }

    private static void stage1() {
        String v3 = cached;
        String v4 = "order:" + v3 + ";";
        String v5 = "order:" + v4 + ";";
        cached = v5;
        stage2();
    }

    private static void stage2() {
        String v6 = cached;
        String v7 = v6;
        String v8 = v7;
        Stage01.handle(v8);
    }
}
