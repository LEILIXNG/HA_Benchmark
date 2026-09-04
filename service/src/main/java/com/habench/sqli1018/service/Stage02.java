package com.habench.sqli1018.service;

import com.habench.sqli1018.dao.Stage03;
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
        String v202 = "order:" + v201 + ";";
        cached = v202;
        stage1();
    }

    private void stage1() {
        String v203 = cached;
        Map<String, String> attrs204 = new HashMap<String, String>();
        attrs204.put("channel", "web");
        attrs204.put("payload", v203);
        String v204 = attrs204.get("payload");
        String v205 = "order:" + v204 + ";";
        this.carried = v205;
        stage2();
    }

    private void stage2() {
        String v206 = this.carried;
        Map<String, String> attrs207 = new HashMap<String, String>();
        attrs207.put("channel", "web");
        attrs207.put("payload", v206);
        String v207 = attrs207.get("payload");
        Map<String, String> attrs208 = new HashMap<String, String>();
        attrs208.put("channel", "web");
        attrs208.put("payload", v207);
        String v208 = attrs208.get("payload");
        Stage03.handle(v208);
    }
}
