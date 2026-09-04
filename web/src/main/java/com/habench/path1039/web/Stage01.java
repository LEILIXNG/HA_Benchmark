package com.habench.path1039.web;

import com.habench.path1039.service.Stage02;
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
        cached = v101;
        stage1();
    }

    private void stage1() {
        String v102 = cached;
        String v103 = v102;
        cached = v103;
        stage2();
    }

    private void stage2() {
        String v104 = cached;
        String v105 = v104;
        String v106 = "order:" + v105 + ";";
        cached = v106;
        stage3();
    }

    private void stage3() {
        String v107 = cached;
        Map<String, String> attrs108 = new HashMap<String, String>();
        attrs108.put("channel", "web");
        attrs108.put("payload", v107);
        String v108 = attrs108.get("payload");
        cached = v108;
        stage4();
    }

    private void stage4() {
        String v109 = cached;
        String v110 = v109;
        this.carried = v110;
        stage5();
    }

    private void stage5() {
        String v111 = this.carried;
        String v112 = "order:" + v111 + ";";
        Stage02.handle(v112);
    }
}
