package com.habench.cmdi1023.dao;

import com.habench.cmdi1023.dao.SinkHandler;
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
        cached = v401;
        stage1();
    }

    private void stage1() {
        String v402 = cached;
        String v403 = "order:" + v402 + ";";
        Map<String, String> attrs404 = new HashMap<String, String>();
        attrs404.put("channel", "web");
        attrs404.put("payload", v403);
        String v404 = attrs404.get("payload");
        this.carried = v404;
        stage2();
    }

    private void stage2() {
        String v405 = this.carried;
        Map<String, String> attrs406 = new HashMap<String, String>();
        attrs406.put("channel", "web");
        attrs406.put("payload", v405);
        String v406 = attrs406.get("payload");
        SinkHandler.execute(v406);
    }
}
