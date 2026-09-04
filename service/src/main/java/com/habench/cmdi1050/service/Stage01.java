package com.habench.cmdi1050.service;

import com.habench.cmdi1050.service.Handler02Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage01 self = new Stage01();
        self.handle(value);
    }

    private void handle(String value) {
        String v101 = "order:" + value + ";";
        cached = v101;
        stage1();
    }

    private void stage1() {
        String v102 = cached;
        String v103 = v102;
        this.carried = v103;
        stage2();
    }

    private void stage2() {
        String v104 = this.carried;
        Map<String, String> attrs105 = new HashMap<String, String>();
        attrs105.put("channel", "web");
        attrs105.put("payload", v104);
        String v105 = attrs105.get("payload");
        cached = v105;
        stage3();
    }

    private void stage3() {
        String v106 = cached;
        Map<String, String> attrs107 = new HashMap<String, String>();
        attrs107.put("channel", "web");
        attrs107.put("payload", v106);
        String v107 = attrs107.get("payload");
        String v108 = v107;
        Handler02Dispatcher.apply(v108);
    }
}
