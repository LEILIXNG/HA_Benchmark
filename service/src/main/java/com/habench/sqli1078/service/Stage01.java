package com.habench.sqli1078.service;

import com.habench.sqli1078.dao.Stage02;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage01 self = new Stage01();
        self.handle(value);
    }

    private void handle(String value) {
        String v101 = "order:" + value + ";";
        cached = v101;
        stage1();
    }

    private void stage1() {
        String v102 = cached;
        String v103 = v102;
        String v104 = "order:" + v103 + ";";
        cached = v104;
        stage2();
    }

    private void stage2() {
        String v105 = cached;
        Map<String, String> attrs106 = new HashMap<String, String>();
        attrs106.put("channel", "web");
        attrs106.put("payload", v105);
        String v106 = attrs106.get("payload");
        Map<String, String> attrs107 = new HashMap<String, String>();
        attrs107.put("channel", "web");
        attrs107.put("payload", v106);
        String v107 = attrs107.get("payload");
        this.carried = v107;
        stage3();
    }

    private void stage3() {
        String v108 = this.carried;
        String v109 = "order:" + v108 + ";";
        this.carried = v109;
        stage4();
    }

    private void stage4() {
        String v110 = this.carried;
        String v111 = "order:" + v110 + ";";
        String v112 = v111;
        Stage02.handle(v112);
    }
}
