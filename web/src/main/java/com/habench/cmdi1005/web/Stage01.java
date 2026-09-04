package com.habench.cmdi1005.web;

import com.habench.cmdi1005.service.Stage02;
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
        this.carried = v104;
        stage2();
    }

    private void stage2() {
        String v105 = this.carried;
        Map<String, String> attrs106 = new HashMap<String, String>();
        attrs106.put("channel", "web");
        attrs106.put("payload", v105);
        String v106 = attrs106.get("payload");
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
        Stage02.handle(v110);
    }
}
