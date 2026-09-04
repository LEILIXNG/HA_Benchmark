package com.habench.sqli1063.dao;

import com.habench.sqli1063.dao.Stage03;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {
    private static String cached;

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        String v202 = v201;
        cached = v202;
        stage1();
    }

    private static void stage1() {
        String v203 = cached;
        String v204 = v203;
        Map<String, String> attrs205 = new HashMap<String, String>();
        attrs205.put("channel", "web");
        attrs205.put("payload", v204);
        String v205 = attrs205.get("payload");
        Stage03.apply(v205);
    }
}
