package com.habench.cmdi1052.service;

import com.habench.cmdi1052.dao.Stage03;
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
        String v203 = "order:" + v202 + ";";
        this.carried = v203;
        stage2();
    }

    private void stage2() {
        String v204 = this.carried;
        String v205 = v204;
        cached = v205;
        stage3();
    }

    private void stage3() {
        String v206 = cached;
        String v207 = "order:" + v206 + ";";
        Map<String, String> attrs208 = new HashMap<String, String>();
        attrs208.put("channel", "web");
        attrs208.put("payload", v207);
        String v208 = attrs208.get("payload");
        Stage03.handle(v208);
    }
}
