package com.habench.sqli1075.dao;

import com.habench.sqli1075.dao.Sanitizer04;
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
        Map<String, String> attrs303 = new HashMap<String, String>();
        attrs303.put("channel", "web");
        attrs303.put("payload", v302);
        String v303 = attrs303.get("payload");
        String v304 = "order:" + v303 + ";";
        cached = v304;
        stage2();
    }

    private void stage2() {
        String v305 = cached;
        String v306 = v305;
        Sanitizer04.apply(v306);
    }
}
