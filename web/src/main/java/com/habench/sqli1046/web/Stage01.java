package com.habench.sqli1046.web;

import com.habench.sqli1046.service.Stage02;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private static String cached;

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        String v102 = "order:" + v101 + ";";
        cached = v102;
        stage1();
    }

    private static void stage1() {
        String v103 = cached;
        String v104 = v103;
        Map<String, String> attrs105 = new HashMap<String, String>();
        attrs105.put("channel", "web");
        attrs105.put("payload", v104);
        String v105 = attrs105.get("payload");
        Stage02.handle(v105);
    }
}
