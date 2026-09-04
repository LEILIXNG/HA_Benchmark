package com.habench.sqli1076.dao;

import com.habench.sqli1076.dao.SinkHandler;
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
        cached = v402;
        stage1();
    }

    private void stage1() {
        String v403 = cached;
        String v404 = "order:" + v403 + ";";
        this.carried = v404;
        stage2();
    }

    private void stage2() {
        String v405 = this.carried;
        String v406 = "order:" + v405 + ";";
        String v407 = "order:" + v406 + ";";
        SinkHandler.execute(v407);
    }
}
