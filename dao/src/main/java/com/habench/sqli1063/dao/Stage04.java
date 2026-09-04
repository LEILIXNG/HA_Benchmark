package com.habench.sqli1063.dao;

import com.habench.sqli1063.dao.Stage05;
import java.util.HashMap;
import java.util.Map;

public final class Stage04 {
    private static String cached;

    public static void handle(String value) {
        Map<String, String> attrs401 = new HashMap<String, String>();
        attrs401.put("channel", "web");
        attrs401.put("payload", value);
        String v401 = attrs401.get("payload");
        String v402 = "order:" + v401 + ";";
        cached = v402;
        stage1();
    }

    private static void stage1() {
        String v403 = cached;
        String v404 = v403;
        String v405 = v404;
        Stage05.handle(v405);
    }
}
