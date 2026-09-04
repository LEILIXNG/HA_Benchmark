package com.habench.sqli1083n.web;

import com.habench.sqli1083n.web.Stage02;
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
        String v103 = "order:" + v102 + ";";
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
        String v107 = v106;
        Stage02.apply(v107);
    }
}
