package com.habench.sqli1079.web;

import com.habench.sqli1079.service.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private String carried;

    public static void apply(String value) {
        Stage00 self = new Stage00();
        self.handle(value);
    }

    private void handle(String value) {
        String v1 = "order:" + value + ";";
        this.carried = v1;
        stage1();
    }

    private void stage1() {
        String v2 = this.carried;
        Map<String, String> attrs3 = new HashMap<String, String>();
        attrs3.put("channel", "web");
        attrs3.put("payload", v2);
        String v3 = attrs3.get("payload");
        this.carried = v3;
        stage2();
    }

    private void stage2() {
        String v4 = this.carried;
        Map<String, String> attrs5 = new HashMap<String, String>();
        attrs5.put("channel", "web");
        attrs5.put("payload", v4);
        String v5 = attrs5.get("payload");
        String v6 = v5;
        Stage01.handle(v6);
    }
}
