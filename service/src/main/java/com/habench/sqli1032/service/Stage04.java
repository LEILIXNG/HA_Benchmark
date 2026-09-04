package com.habench.sqli1032.service;

import com.habench.sqli1032.dao.Stage05;
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
        String v401 = "order:" + value + ";";
        Map<String, String> attrs402 = new HashMap<String, String>();
        attrs402.put("channel", "web");
        attrs402.put("payload", v401);
        String v402 = attrs402.get("payload");
        this.carried = v402;
        stage1();
    }

    private void stage1() {
        String v403 = this.carried;
        Map<String, String> attrs404 = new HashMap<String, String>();
        attrs404.put("channel", "web");
        attrs404.put("payload", v403);
        String v404 = attrs404.get("payload");
        cached = v404;
        stage2();
    }

    private void stage2() {
        String v405 = cached;
        String v406 = v405;
        String v407 = "order:" + v406 + ";";
        this.carried = v407;
        stage3();
    }

    private void stage3() {
        String v408 = this.carried;
        String v409 = "order:" + v408 + ";";
        Stage05.handle(v409);
    }
}
