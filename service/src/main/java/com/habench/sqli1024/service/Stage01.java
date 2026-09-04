package com.habench.sqli1024.service;

import com.habench.sqli1024.service.Stage02;
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
        this.carried = v101;
        stage1();
    }

    private void stage1() {
        String v102 = this.carried;
        Map<String, String> attrs103 = new HashMap<String, String>();
        attrs103.put("channel", "web");
        attrs103.put("payload", v102);
        String v103 = attrs103.get("payload");
        Map<String, String> attrs104 = new HashMap<String, String>();
        attrs104.put("channel", "web");
        attrs104.put("payload", v103);
        String v104 = attrs104.get("payload");
        cached = v104;
        stage2();
    }

    private void stage2() {
        String v105 = cached;
        String v106 = "order:" + v105 + ";";
        this.carried = v106;
        stage3();
    }

    private void stage3() {
        String v107 = this.carried;
        String v108 = "order:" + v107 + ";";
        this.carried = v108;
        stage4();
    }

    private void stage4() {
        String v109 = this.carried;
        String v110 = "order:" + v109 + ";";
        String v111 = "order:" + v110 + ";";
        cached = v111;
        stage5();
    }

    private void stage5() {
        String v112 = cached;
        String v113 = v112;
        String v114 = "order:" + v113 + ";";
        cached = v114;
        stage6();
    }

    private void stage6() {
        String v115 = cached;
        String v116 = "order:" + v115 + ";";
        Map<String, String> attrs117 = new HashMap<String, String>();
        attrs117.put("channel", "web");
        attrs117.put("payload", v116);
        String v117 = attrs117.get("payload");
        this.carried = v117;
        stage7();
    }

    private void stage7() {
        String v118 = this.carried;
        Map<String, String> attrs119 = new HashMap<String, String>();
        attrs119.put("channel", "web");
        attrs119.put("payload", v118);
        String v119 = attrs119.get("payload");
        String v120 = v119;
        Stage02.handle(v120);
    }
}
