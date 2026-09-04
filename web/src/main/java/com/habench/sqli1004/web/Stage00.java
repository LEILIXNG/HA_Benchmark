package com.habench.sqli1004.web;

import com.habench.sqli1004.service.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private String carried;

    public static void apply(String value) {
        Stage00 self = new Stage00();
        self.handle(value);
    }

    private void handle(String value) {
        Map<String, String> attrs1 = new HashMap<String, String>();
        attrs1.put("channel", "web");
        attrs1.put("payload", value);
        String v1 = attrs1.get("payload");
        String v2 = v1;
        this.carried = v2;
        stage1();
    }

    private void stage1() {
        String v3 = this.carried;
        String v4 = v3;
        Map<String, String> attrs5 = new HashMap<String, String>();
        attrs5.put("channel", "web");
        attrs5.put("payload", v4);
        String v5 = attrs5.get("payload");
        Stage01.handle(v5);
    }
}
