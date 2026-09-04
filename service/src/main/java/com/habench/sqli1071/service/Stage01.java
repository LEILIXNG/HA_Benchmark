package com.habench.sqli1071.service;

import com.habench.sqli1071.dao.Stage02;
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
        String v102 = v101;
        this.carried = v102;
        stage1();
    }

    private void stage1() {
        String v103 = this.carried;
        String v104 = v103;
        String v105 = "order:" + v104 + ";";
        cached = v105;
        stage2();
    }

    private void stage2() {
        String v106 = cached;
        String v107 = "order:" + v106 + ";";
        cached = v107;
        stage3();
    }

    private void stage3() {
        String v108 = cached;
        String v109 = v108;
        this.carried = v109;
        stage4();
    }

    private void stage4() {
        String v110 = this.carried;
        String v111 = v110;
        String v112 = v111;
        this.carried = v112;
        stage5();
    }

    private void stage5() {
        String v113 = this.carried;
        Map<String, String> attrs114 = new HashMap<String, String>();
        attrs114.put("channel", "web");
        attrs114.put("payload", v113);
        String v114 = attrs114.get("payload");
        Map<String, String> attrs115 = new HashMap<String, String>();
        attrs115.put("channel", "web");
        attrs115.put("payload", v114);
        String v115 = attrs115.get("payload");
        Stage02.handle(v115);
    }
}
