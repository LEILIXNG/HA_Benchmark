package com.habench.sqli1012n.web;

import com.habench.sqli1012n.service.Stage02;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private String carried;

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
        this.carried = v102;
        stage1();
    }

    private void stage1() {
        String v103 = this.carried;
        String v104 = v103;
        this.carried = v104;
        stage2();
    }

    private void stage2() {
        String v105 = this.carried;
        Map<String, String> attrs106 = new HashMap<String, String>();
        attrs106.put("channel", "web");
        attrs106.put("payload", v105);
        String v106 = attrs106.get("payload");
        Stage02.apply(v106);
    }
}
