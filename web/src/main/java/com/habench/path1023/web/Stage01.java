package com.habench.path1023.web;

import com.habench.path1023.service.Stage02;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private String carried;

    public static void apply(String value) {
        Stage01 self = new Stage01();
        self.handle(value);
    }

    private void handle(String value) {
        String v101 = "order:" + value + ";";
        this.carried = v101;
        stage1();
    }

    private void stage1() {
        String v102 = this.carried;
        Map<String, String> attrs103 = new HashMap<String, String>();
        attrs103.put("channel", "web");
        attrs103.put("payload", v102);
        String v103 = attrs103.get("payload");
        this.carried = v103;
        stage2();
    }

    private void stage2() {
        String v104 = this.carried;
        Map<String, String> attrs105 = new HashMap<String, String>();
        attrs105.put("channel", "web");
        attrs105.put("payload", v104);
        String v105 = attrs105.get("payload");
        Map<String, String> attrs106 = new HashMap<String, String>();
        attrs106.put("channel", "web");
        attrs106.put("payload", v105);
        String v106 = attrs106.get("payload");
        Stage02.apply(v106);
    }
}
