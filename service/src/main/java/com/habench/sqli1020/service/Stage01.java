package com.habench.sqli1020.service;

import com.habench.sqli1020.dao.Stage02;
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
        String v103 = v102;
        Map<String, String> attrs104 = new HashMap<String, String>();
        attrs104.put("channel", "web");
        attrs104.put("payload", v103);
        String v104 = attrs104.get("payload");
        Stage02.handle(v104);
    }
}
