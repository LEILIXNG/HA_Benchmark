package com.habench.path1010n.service;

import com.habench.path1010n.dao.Stage03;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {
    private static String cached;

    public static void handle(String value) {
        String v201 = value;
        cached = v201;
        stage1();
    }

    private static void stage1() {
        String v202 = cached;
        Map<String, String> attrs203 = new HashMap<String, String>();
        attrs203.put("channel", "web");
        attrs203.put("payload", v202);
        String v203 = attrs203.get("payload");
        Stage03.apply(v203);
    }
}
