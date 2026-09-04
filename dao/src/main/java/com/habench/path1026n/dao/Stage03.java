package com.habench.path1026n.dao;

import com.habench.path1026n.dao.Sanitizer04;
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
        this.carried = v301;
        stage1();
    }

    private void stage1() {
        String v302 = this.carried;
        String v303 = "order:" + v302 + ";";
        cached = v303;
        stage2();
    }

    private void stage2() {
        String v304 = cached;
        String v305 = v304;
        String v306 = v305;
        cached = v306;
        stage3();
    }

    private void stage3() {
        String v307 = cached;
        String v308 = "order:" + v307 + ";";
        Sanitizer04.apply(v308);
    }
}
