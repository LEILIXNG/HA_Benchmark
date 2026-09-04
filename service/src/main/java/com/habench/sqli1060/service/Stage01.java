package com.habench.sqli1060.service;

import com.habench.sqli1060.service.Sanitizer02;
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
        Map<String, String> attrs101 = new HashMap<String, String>();
        attrs101.put("channel", "web");
        attrs101.put("payload", value);
        String v101 = attrs101.get("payload");
        Map<String, String> attrs102 = new HashMap<String, String>();
        attrs102.put("channel", "web");
        attrs102.put("payload", v101);
        String v102 = attrs102.get("payload");
        cached = v102;
        stage1();
    }

    private void stage1() {
        String v103 = cached;
        String v104 = "order:" + v103 + ";";
        this.carried = v104;
        stage2();
    }

    private void stage2() {
        String v105 = this.carried;
        String v106 = v105;
        String v107 = v106;
        cached = v107;
        stage3();
    }

    private void stage3() {
        String v108 = cached;
        String v109 = "order:" + v108 + ";";
        String v110 = "order:" + v109 + ";";
        Sanitizer02.apply(v110);
    }
}
