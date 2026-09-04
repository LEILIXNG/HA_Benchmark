package com.habench.path1005.web;

import com.habench.path1005.service.Stage02;
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
        Map<String, String> attrs104 = new HashMap<String, String>();
        attrs104.put("channel", "web");
        attrs104.put("payload", v103);
        String v104 = attrs104.get("payload");
        String v105 = "order:" + v104 + ";";
        cached = v105;
        stage2();
    }

    private void stage2() {
        String v106 = cached;
        String v107 = v106;
        this.carried = v107;
        stage3();
    }

    private void stage3() {
        String v108 = this.carried;
        Map<String, String> attrs109 = new HashMap<String, String>();
        attrs109.put("channel", "web");
        attrs109.put("payload", v108);
        String v109 = attrs109.get("payload");
        String v110 = "order:" + v109 + ";";
        Stage02.handle(v110);
    }
}
