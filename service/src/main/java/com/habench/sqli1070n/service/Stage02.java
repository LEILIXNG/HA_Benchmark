package com.habench.sqli1070n.service;

import com.habench.sqli1070n.service.Sanitizer03;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {
    private String carried;

    public static void apply(String value) {
        Stage02 self = new Stage02();
        self.handle(value);
    }

    private void handle(String value) {
        Map<String, String> attrs201 = new HashMap<String, String>();
        attrs201.put("channel", "web");
        attrs201.put("payload", value);
        String v201 = attrs201.get("payload");
        this.carried = v201;
        stage1();
    }

    private void stage1() {
        String v202 = this.carried;
        String v203 = "order:" + v202 + ";";
        Sanitizer03.apply(v203);
    }
}
