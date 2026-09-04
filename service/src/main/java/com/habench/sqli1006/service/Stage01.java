package com.habench.sqli1006.service;

import com.habench.sqli1006.service.Handler02Dispatcher;
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
        cached = v103;
        stage2();
    }

    private void stage2() {
        String v104 = cached;
        Map<String, String> attrs105 = new HashMap<String, String>();
        attrs105.put("channel", "web");
        attrs105.put("payload", v104);
        String v105 = attrs105.get("payload");
        String v106 = "order:" + v105 + ";";
        cached = v106;
        stage3();
    }

    private void stage3() {
        String v107 = cached;
        String v108 = v107;
        cached = v108;
        stage4();
    }

    private void stage4() {
        String v109 = cached;
        Map<String, String> attrs110 = new HashMap<String, String>();
        attrs110.put("channel", "web");
        attrs110.put("payload", v109);
        String v110 = attrs110.get("payload");
        String v111 = "order:" + v110 + ";";
        this.carried = v111;
        stage5();
    }

    private void stage5() {
        String v112 = this.carried;
        Map<String, String> attrs113 = new HashMap<String, String>();
        attrs113.put("channel", "web");
        attrs113.put("payload", v112);
        String v113 = attrs113.get("payload");
        this.carried = v113;
        stage6();
    }

    private void stage6() {
        String v114 = this.carried;
        String v115 = "order:" + v114 + ";";
        Handler02Dispatcher.apply(v115);
    }
}
