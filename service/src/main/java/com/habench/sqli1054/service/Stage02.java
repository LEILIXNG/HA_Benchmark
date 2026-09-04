package com.habench.sqli1054.service;

import com.habench.sqli1054.service.SinkHandler;
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
        String v201 = "order:" + value + ";";
        this.carried = v201;
        stage1();
    }

    private void stage1() {
        String v202 = this.carried;
        String v203 = "order:" + v202 + ";";
        String v204 = "order:" + v203 + ";";
        this.carried = v204;
        stage2();
    }

    private void stage2() {
        String v205 = this.carried;
        Map<String, String> attrs206 = new HashMap<String, String>();
        attrs206.put("channel", "web");
        attrs206.put("payload", v205);
        String v206 = attrs206.get("payload");
        Map<String, String> attrs207 = new HashMap<String, String>();
        attrs207.put("channel", "web");
        attrs207.put("payload", v206);
        String v207 = attrs207.get("payload");
        cached = v207;
        stage3();
    }

    private void stage3() {
        String v208 = cached;
        Map<String, String> attrs209 = new HashMap<String, String>();
        attrs209.put("channel", "web");
        attrs209.put("payload", v208);
        String v209 = attrs209.get("payload");
        String v210 = "order:" + v209 + ";";
        SinkHandler.execute(v210);
    }
}
