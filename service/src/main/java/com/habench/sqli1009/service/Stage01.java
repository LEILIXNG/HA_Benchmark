package com.habench.sqli1009.service;

import com.habench.sqli1009.service.Stage02;
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
        String v102 = v101;
        cached = v102;
        stage1();
    }

    private void stage1() {
        String v103 = cached;
        String v104 = v103;
        String v105 = v104;
        cached = v105;
        stage2();
    }

    private void stage2() {
        String v106 = cached;
        Map<String, String> attrs107 = new HashMap<String, String>();
        attrs107.put("channel", "web");
        attrs107.put("payload", v106);
        String v107 = attrs107.get("payload");
        this.carried = v107;
        stage3();
    }

    private void stage3() {
        String v108 = this.carried;
        Map<String, String> attrs109 = new HashMap<String, String>();
        attrs109.put("channel", "web");
        attrs109.put("payload", v108);
        String v109 = attrs109.get("payload");
        this.carried = v109;
        stage4();
    }

    private void stage4() {
        String v110 = this.carried;
        String v111 = "order:" + v110 + ";";
        String v112 = "order:" + v111 + ";";
        Stage02.apply(v112);
    }
}
