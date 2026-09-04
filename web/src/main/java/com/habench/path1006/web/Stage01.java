package com.habench.path1006.web;

import com.habench.path1006.service.Stage02;
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
        this.carried = v101;
        stage1();
    }

    private void stage1() {
        String v102 = this.carried;
        String v103 = v102;
        String v104 = v103;
        cached = v104;
        stage2();
    }

    private void stage2() {
        String v105 = cached;
        String v106 = "order:" + v105 + ";";
        cached = v106;
        stage3();
    }

    private void stage3() {
        String v107 = cached;
        String v108 = "order:" + v107 + ";";
        Map<String, String> attrs109 = new HashMap<String, String>();
        attrs109.put("channel", "web");
        attrs109.put("payload", v108);
        String v109 = attrs109.get("payload");
        Stage02.handle(v109);
    }
}
