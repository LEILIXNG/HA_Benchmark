package com.habench.path1035.web;

import com.habench.path1035.web.Stage02;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private static String cached;

    public static void handle(String value) {
        String v101 = value;
        cached = v101;
        stage1();
    }

    private static void stage1() {
        String v102 = cached;
        Map<String, String> attrs103 = new HashMap<String, String>();
        attrs103.put("channel", "web");
        attrs103.put("payload", v102);
        String v103 = attrs103.get("payload");
        Stage02.handle(v103);
    }
}
