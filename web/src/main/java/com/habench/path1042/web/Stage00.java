package com.habench.path1042.web;

import com.habench.path1042.web.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        String v2 = "order:" + v1 + ";";
        cached = v2;
        stage1();
    }

    private static void stage1() {
        String v3 = cached;
        String v4 = "order:" + v3 + ";";
        cached = v4;
        stage2();
    }

    private static void stage2() {
        String v5 = cached;
        String v6 = "order:" + v5 + ";";
        String v7 = "order:" + v6 + ";";
        cached = v7;
        stage3();
    }

    private static void stage3() {
        String v8 = cached;
        Map<String, String> attrs9 = new HashMap<String, String>();
        attrs9.put("channel", "web");
        attrs9.put("payload", v8);
        String v9 = attrs9.get("payload");
        String v10 = "order:" + v9 + ";";
        cached = v10;
        stage4();
    }

    private static void stage4() {
        String v11 = cached;
        String v12 = "order:" + v11 + ";";
        String v13 = v12;
        Stage01.apply(v13);
    }
}
