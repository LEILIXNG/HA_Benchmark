package com.habench.sqli1008.service;

import com.habench.sqli1008.dao.Stage03;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {
    private static String cached;

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        Map<String, String> attrs202 = new HashMap<String, String>();
        attrs202.put("channel", "web");
        attrs202.put("payload", v201);
        String v202 = attrs202.get("payload");
        cached = v202;
        stage1();
    }

    private static void stage1() {
        String v203 = cached;
        String v204 = v203;
        Stage03.apply(v204);
    }
}
