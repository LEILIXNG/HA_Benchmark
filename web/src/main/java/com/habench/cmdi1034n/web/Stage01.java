package com.habench.cmdi1034n.web;

import com.habench.cmdi1034n.service.Stage02;
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
        this.carried = v101;
        stage1();
    }

    private void stage1() {
        String v102 = this.carried;
        Map<String, String> attrs103 = new HashMap<String, String>();
        attrs103.put("channel", "web");
        attrs103.put("payload", v102);
        String v103 = attrs103.get("payload");
        Stage02.handle(v103);
    }
}
