package com.habench.cmdi1013.web;

import com.habench.cmdi1013.service.Stage02;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private String carried;

    public static void apply(String value) {
        Stage01 self = new Stage01();
        self.handle(value);
    }

    private void handle(String value) {
        Map<String, String> attrs101 = new HashMap<String, String>();
        attrs101.put("channel", "web");
        attrs101.put("payload", value);
        String v101 = attrs101.get("payload");
        Map<String, String> attrs102 = new HashMap<String, String>();
        attrs102.put("channel", "web");
        attrs102.put("payload", v101);
        String v102 = attrs102.get("payload");
        this.carried = v102;
        stage1();
    }

    private void stage1() {
        String v103 = this.carried;
        Map<String, String> attrs104 = new HashMap<String, String>();
        attrs104.put("channel", "web");
        attrs104.put("payload", v103);
        String v104 = attrs104.get("payload");
        String v105 = "order:" + v104 + ";";
        Stage02.apply(v105);
    }
}
