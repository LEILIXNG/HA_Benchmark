package com.habench.path1011.dao;

import com.habench.path1011.dao.SinkHandler;
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
        String v402 = "order:" + v401 + ";";
        cached = v402;
        stage1();
    }

    private void stage1() {
        String v403 = cached;
        Map<String, String> attrs404 = new HashMap<String, String>();
        attrs404.put("channel", "web");
        attrs404.put("payload", v403);
        String v404 = attrs404.get("payload");
        String v405 = v404;
        cached = v405;
        stage2();
    }

    private void stage2() {
        String v406 = cached;
        String v407 = "order:" + v406 + ";";
        this.carried = v407;
        stage3();
    }

    private void stage3() {
        String v408 = this.carried;
        Map<String, String> attrs409 = new HashMap<String, String>();
        attrs409.put("channel", "web");
        attrs409.put("payload", v408);
        String v409 = attrs409.get("payload");
        SinkHandler.execute(v409);
    }
}
