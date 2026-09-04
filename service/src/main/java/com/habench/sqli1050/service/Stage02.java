package com.habench.sqli1050.service;

import com.habench.sqli1050.service.Sanitizer03;
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
        String v202 = "order:" + v201 + ";";
        cached = v202;
        stage1();
    }

    private void stage1() {
        String v203 = cached;
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
        Sanitizer03.apply(v206);
    }
}
