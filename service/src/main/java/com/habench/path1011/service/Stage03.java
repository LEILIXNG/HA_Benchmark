package com.habench.path1011.service;

import com.habench.path1011.dao.Stage04;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {
    private String carried;

    public static void apply(String value) {
        Stage03 self = new Stage03();
        self.handle(value);
    }

    private void handle(String value) {
        Map<String, String> attrs301 = new HashMap<String, String>();
        attrs301.put("channel", "web");
        attrs301.put("payload", value);
        String v301 = attrs301.get("payload");
        this.carried = v301;
        stage1();
    }

    private void stage1() {
        String v302 = this.carried;
        String v303 = "order:" + v302 + ";";
        String v304 = v303;
        this.carried = v304;
        stage2();
    }

    private void stage2() {
        String v305 = this.carried;
        String v306 = v305;
        this.carried = v306;
        stage3();
    }

    private void stage3() {
        String v307 = this.carried;
        String v308 = v307;
        Map<String, String> attrs309 = new HashMap<String, String>();
        attrs309.put("channel", "web");
        attrs309.put("payload", v308);
        String v309 = attrs309.get("payload");
        Stage04.apply(v309);
    }
}
