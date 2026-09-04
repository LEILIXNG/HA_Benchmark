package com.habench.sqli1007.service;

import com.habench.sqli1007.dao.Stage05;
import java.util.HashMap;
import java.util.Map;

public final class Stage04 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage04 self = new Stage04();
        self.handle(value);
    }

    private void handle(String value) {
        String v401 = value;
        String v402 = "order:" + v401 + ";";
        cached = v402;
        stage1();
    }

    private void stage1() {
        String v403 = cached;
        String v404 = "order:" + v403 + ";";
        Map<String, String> attrs405 = new HashMap<String, String>();
        attrs405.put("channel", "web");
        attrs405.put("payload", v404);
        String v405 = attrs405.get("payload");
        this.carried = v405;
        stage2();
    }

    private void stage2() {
        String v406 = this.carried;
        String v407 = v406;
        Map<String, String> attrs408 = new HashMap<String, String>();
        attrs408.put("channel", "web");
        attrs408.put("payload", v407);
        String v408 = attrs408.get("payload");
        Stage05.handle(v408);
    }
}
