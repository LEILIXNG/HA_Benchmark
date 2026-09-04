package com.habench.path1032.web;

import com.habench.path1032.service.Stage03;
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
        String v202 = v201;
        this.carried = v202;
        stage1();
    }

    private void stage1() {
        String v203 = this.carried;
        String v204 = "order:" + v203 + ";";
        Map<String, String> attrs205 = new HashMap<String, String>();
        attrs205.put("channel", "web");
        attrs205.put("payload", v204);
        String v205 = attrs205.get("payload");
        cached = v205;
        stage2();
    }

    private void stage2() {
        String v206 = cached;
        String v207 = "order:" + v206 + ";";
        String v208 = v207;
        this.carried = v208;
        stage3();
    }

    private void stage3() {
        String v209 = this.carried;
        String v210 = "order:" + v209 + ";";
        Stage03.apply(v210);
    }
}
