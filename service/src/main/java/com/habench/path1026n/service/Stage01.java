package com.habench.path1026n.service;

import com.habench.path1026n.service.Stage02;
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
        String v103 = "order:" + v102 + ";";
        Map<String, String> attrs104 = new HashMap<String, String>();
        attrs104.put("channel", "web");
        attrs104.put("payload", v103);
        String v104 = attrs104.get("payload");
        Stage02.apply(v104);
    }
}
