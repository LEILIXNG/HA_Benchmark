package com.habench.cmdi1059.web;

import com.habench.cmdi1059.service.Stage03;
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
        cached = v201;
        stage1();
    }

    private void stage1() {
        String v202 = cached;
        Map<String, String> attrs203 = new HashMap<String, String>();
        attrs203.put("channel", "web");
        attrs203.put("payload", v202);
        String v203 = attrs203.get("payload");
        Map<String, String> attrs204 = new HashMap<String, String>();
        attrs204.put("channel", "web");
        attrs204.put("payload", v203);
        String v204 = attrs204.get("payload");
        cached = v204;
        stage2();
    }

    private void stage2() {
        String v205 = cached;
        String v206 = v205;
        this.carried = v206;
        stage3();
    }

    private void stage3() {
        String v207 = this.carried;
        String v208 = v207;
        String v209 = "order:" + v208 + ";";
        cached = v209;
        stage4();
    }

    private void stage4() {
        String v210 = cached;
        String v211 = v210;
        Map<String, String> attrs212 = new HashMap<String, String>();
        attrs212.put("channel", "web");
        attrs212.put("payload", v211);
        String v212 = attrs212.get("payload");
        Stage03.apply(v212);
    }
}
