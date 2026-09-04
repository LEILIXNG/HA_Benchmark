package com.habench.sqli1022.service;

import com.habench.sqli1022.service.Stage05;
import java.util.HashMap;
import java.util.Map;

public final class Stage04 {
    private static String cached;

    public static void handle(String value) {
        String v401 = "order:" + value + ";";
        Map<String, String> attrs402 = new HashMap<String, String>();
        attrs402.put("channel", "web");
        attrs402.put("payload", v401);
        String v402 = attrs402.get("payload");
        cached = v402;
        stage1();
    }

    private static void stage1() {
        String v403 = cached;
        String v404 = v403;
        Stage05.handle(v404);
    }
}
