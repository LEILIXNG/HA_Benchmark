package com.habench.cmdi1038.service;

import com.habench.cmdi1038.dao.Stage03;
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
        String v202 = v201;
        cached = v202;
        stage1();
    }

    private void stage1() {
        String v203 = cached;
        String v204 = "order:" + v203 + ";";
        String v205 = "order:" + v204 + ";";
        cached = v205;
        stage2();
    }

    private void stage2() {
        String v206 = cached;
        String v207 = v206;
        String v208 = "order:" + v207 + ";";
        cached = v208;
        stage3();
    }

    private void stage3() {
        String v209 = cached;
        Map<String, String> attrs210 = new HashMap<String, String>();
        attrs210.put("channel", "web");
        attrs210.put("payload", v209);
        String v210 = attrs210.get("payload");
        String v211 = "order:" + v210 + ";";
        this.carried = v211;
        stage4();
    }

    private void stage4() {
        String v212 = this.carried;
        String v213 = v212;
        String v214 = v213;
        Stage03.apply(v214);
    }
}
