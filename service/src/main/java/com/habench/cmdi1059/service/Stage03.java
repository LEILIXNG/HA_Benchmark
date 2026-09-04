package com.habench.cmdi1059.service;

import com.habench.cmdi1059.service.Stage04;
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
        String v301 = "order:" + value + ";";
        this.carried = v301;
        stage1();
    }

    private void stage1() {
        String v302 = this.carried;
        String v303 = v302;
        String v304 = "order:" + v303 + ";";
        cached = v304;
        stage2();
    }

    private void stage2() {
        String v305 = cached;
        Map<String, String> attrs306 = new HashMap<String, String>();
        attrs306.put("channel", "web");
        attrs306.put("payload", v305);
        String v306 = attrs306.get("payload");
        String v307 = v306;
        Stage04.apply(v307);
    }
}
