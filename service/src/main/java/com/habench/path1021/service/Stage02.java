package com.habench.path1021.service;

import com.habench.path1021.service.Handler03Dispatcher;
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
        String v201 = value;
        cached = v201;
        stage1();
    }

    private void stage1() {
        String v202 = cached;
        Map<String, String> attrs203 = new HashMap<String, String>();
        attrs203.put("channel", "web");
        attrs203.put("payload", v202);
        String v203 = attrs203.get("payload");
        String v204 = "order:" + v203 + ";";
        this.carried = v204;
        stage2();
    }

    private void stage2() {
        String v205 = this.carried;
        String v206 = "order:" + v205 + ";";
        this.carried = v206;
        stage3();
    }

    private void stage3() {
        String v207 = this.carried;
        String v208 = v207;
        String v209 = v208;
        this.carried = v209;
        stage4();
    }

    private void stage4() {
        String v210 = this.carried;
        Map<String, String> attrs211 = new HashMap<String, String>();
        attrs211.put("channel", "web");
        attrs211.put("payload", v210);
        String v211 = attrs211.get("payload");
        this.carried = v211;
        stage5();
    }

    private void stage5() {
        String v212 = this.carried;
        Map<String, String> attrs213 = new HashMap<String, String>();
        attrs213.put("channel", "web");
        attrs213.put("payload", v212);
        String v213 = attrs213.get("payload");
        Map<String, String> attrs214 = new HashMap<String, String>();
        attrs214.put("channel", "web");
        attrs214.put("payload", v213);
        String v214 = attrs214.get("payload");
        Handler03Dispatcher.apply(v214);
    }
}
