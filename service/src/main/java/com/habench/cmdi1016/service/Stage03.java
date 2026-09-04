package com.habench.cmdi1016.service;

import com.habench.cmdi1016.dao.Stage04;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage03 self = new Stage03();
        self.handle(value);
    }

    private void handle(String value) {
        Map<String, String> attrs301 = new HashMap<String, String>();
        attrs301.put("channel", "web");
        attrs301.put("payload", value);
        String v301 = attrs301.get("payload");
        cached = v301;
        stage1();
    }

    private void stage1() {
        String v302 = cached;
        Map<String, String> attrs303 = new HashMap<String, String>();
        attrs303.put("channel", "web");
        attrs303.put("payload", v302);
        String v303 = attrs303.get("payload");
        cached = v303;
        stage2();
    }

    private void stage2() {
        String v304 = cached;
        String v305 = "order:" + v304 + ";";
        this.carried = v305;
        stage3();
    }

    private void stage3() {
        String v306 = this.carried;
        String v307 = "order:" + v306 + ";";
        Map<String, String> attrs308 = new HashMap<String, String>();
        attrs308.put("channel", "web");
        attrs308.put("payload", v307);
        String v308 = attrs308.get("payload");
        cached = v308;
        stage4();
    }

    private void stage4() {
        String v309 = cached;
        String v310 = "order:" + v309 + ";";
        this.carried = v310;
        stage5();
    }

    private void stage5() {
        String v311 = this.carried;
        String v312 = v311;
        Stage04.handle(v312);
    }
}
