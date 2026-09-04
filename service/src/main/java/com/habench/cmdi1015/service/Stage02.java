package com.habench.cmdi1015.service;

import com.habench.cmdi1015.dao.Stage03;
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
        Map<String, String> attrs202 = new HashMap<String, String>();
        attrs202.put("channel", "web");
        attrs202.put("payload", v201);
        String v202 = attrs202.get("payload");
        this.carried = v202;
        stage1();
    }

    private void stage1() {
        String v203 = this.carried;
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
        String v207 = "order:" + v206 + ";";
        cached = v207;
        stage3();
    }

    private void stage3() {
        String v208 = cached;
        String v209 = "order:" + v208 + ";";
        Stage03.apply(v209);
    }
}
