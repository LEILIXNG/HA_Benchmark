package com.habench.sqli1004.service;

import com.habench.sqli1004.dao.Stage02;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private static String cached;

    public static void handle(String value) {
        String v101 = value;
        String v102 = "order:" + v101 + ";";
        cached = v102;
        stage1();
    }

    private static void stage1() {
        String v103 = cached;
        Map<String, String> attrs104 = new HashMap<String, String>();
        attrs104.put("channel", "web");
        attrs104.put("payload", v103);
        String v104 = attrs104.get("payload");
        String v105 = "order:" + v104 + ";";
        Stage02.handle(v105);
    }
}
