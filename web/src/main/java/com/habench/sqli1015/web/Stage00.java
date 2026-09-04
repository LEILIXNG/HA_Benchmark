package com.habench.sqli1015.web;

import com.habench.sqli1015.service.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private String carried;

    public static void apply(String value) {
        Stage00 self = new Stage00();
        self.handle(value);
    }

    private void handle(String value) {
        String v1 = value;
        Map<String, String> attrs2 = new HashMap<String, String>();
        attrs2.put("channel", "web");
        attrs2.put("payload", v1);
        String v2 = attrs2.get("payload");
        this.carried = v2;
        stage1();
    }

    private void stage1() {
        String v3 = this.carried;
        String v4 = v3;
        Stage01.handle(v4);
    }
}
