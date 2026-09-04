package com.habench.path1024.web;

import com.habench.path1024.web.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        Map<String, String> attrs2 = new HashMap<String, String>();
        attrs2.put("channel", "web");
        attrs2.put("payload", v1);
        String v2 = attrs2.get("payload");
        cached = v2;
        stage1();
    }

    private static void stage1() {
        String v3 = cached;
        String v4 = v3;
        Stage01.handle(v4);
    }
}
