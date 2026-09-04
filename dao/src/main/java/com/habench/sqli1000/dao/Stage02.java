package com.habench.sqli1000.dao;

import com.habench.sqli1000.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage02 self = new Stage02();
        self.handle(value);
    }

    private void handle(String value) {
        Map<String, String> attrs201 = new HashMap<String, String>();
        attrs201.put("channel", "web");
        attrs201.put("payload", value);
        String v201 = attrs201.get("payload");
        cached = v201;
        stage1();
    }

    private void stage1() {
        String v202 = cached;
        String v203 = "order:" + v202 + ";";
        this.carried = v203;
        stage2();
    }

    private void stage2() {
        String v204 = this.carried;
        String v205 = v204;
        String v206 = v205;
        SinkHandler.execute(v206);
    }
}
