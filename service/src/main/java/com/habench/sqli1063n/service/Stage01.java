package com.habench.sqli1063n.service;

import com.habench.sqli1063n.dao.Stage02;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private static String cached;

    public static void handle(String value) {
        String v101 = value;
        Map<String, String> attrs102 = new HashMap<String, String>();
        attrs102.put("channel", "web");
        attrs102.put("payload", v101);
        String v102 = attrs102.get("payload");
        cached = v102;
        stage1();
    }

    private static void stage1() {
        String v103 = cached;
        String v104 = "order:" + v103 + ";";
        Stage02.handle(v104);
    }
}
