package com.habench.sqli1025.service;

import com.habench.sqli1025.service.Sanitizer02;
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
        String v101 = value;
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
        Map<String, String> attrs105 = new HashMap<String, String>();
        attrs105.put("channel", "web");
        attrs105.put("payload", v104);
        String v105 = attrs105.get("payload");
        this.carried = v105;
        stage2();
    }

    private void stage2() {
        String v106 = this.carried;
        String v107 = v106;
        Map<String, String> attrs108 = new HashMap<String, String>();
        attrs108.put("channel", "web");
        attrs108.put("payload", v107);
        String v108 = attrs108.get("payload");
        Sanitizer02.apply(v108);
    }
}
