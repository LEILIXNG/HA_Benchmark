package com.habench.sqli1075.service;

import com.habench.sqli1075.service.Stage02;
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
        String v102 = "order:" + v101 + ";";
        this.carried = v102;
        stage1();
    }

    private void stage1() {
        String v103 = this.carried;
        Map<String, String> attrs104 = new HashMap<String, String>();
        attrs104.put("channel", "web");
        attrs104.put("payload", v103);
        String v104 = attrs104.get("payload");
        String v105 = v104;
        Stage02.apply(v105);
    }
}
