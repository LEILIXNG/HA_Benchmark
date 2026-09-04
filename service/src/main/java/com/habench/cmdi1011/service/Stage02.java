package com.habench.cmdi1011.service;

import com.habench.cmdi1011.dao.Stage03;
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
        Map<String, String> attrs202 = new HashMap<String, String>();
        attrs202.put("channel", "web");
        attrs202.put("payload", v201);
        String v202 = attrs202.get("payload");
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
        String v206 = v205;
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
        cached = v209;
        stage4();
    }

    private void stage4() {
        String v210 = cached;
        Map<String, String> attrs211 = new HashMap<String, String>();
        attrs211.put("channel", "web");
        attrs211.put("payload", v210);
        String v211 = attrs211.get("payload");
        String v212 = "order:" + v211 + ";";
        Stage03.handle(v212);
    }
}
