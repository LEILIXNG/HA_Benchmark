package com.habench.sqli1073n.dao;

import com.habench.sqli1073n.dao.Handler04Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage03 self = new Stage03();
        self.handle(value);
    }

    private void handle(String value) {
        String v301 = "order:" + value + ";";
        Map<String, String> attrs302 = new HashMap<String, String>();
        attrs302.put("channel", "web");
        attrs302.put("payload", v301);
        String v302 = attrs302.get("payload");
        this.carried = v302;
        stage1();
    }

    private void stage1() {
        String v303 = this.carried;
        String v304 = "order:" + v303 + ";";
        String v305 = "order:" + v304 + ";";
        cached = v305;
        stage2();
    }

    private void stage2() {
        String v306 = cached;
        String v307 = "order:" + v306 + ";";
        String v308 = v307;
        this.carried = v308;
        stage3();
    }

    private void stage3() {
        String v309 = this.carried;
        Map<String, String> attrs310 = new HashMap<String, String>();
        attrs310.put("channel", "web");
        attrs310.put("payload", v309);
        String v310 = attrs310.get("payload");
        String v311 = v310;
        cached = v311;
        stage4();
    }

    private void stage4() {
        String v312 = cached;
        Map<String, String> attrs313 = new HashMap<String, String>();
        attrs313.put("channel", "web");
        attrs313.put("payload", v312);
        String v313 = attrs313.get("payload");
        String v314 = "order:" + v313 + ";";
        cached = v314;
        stage5();
    }

    private void stage5() {
        String v315 = cached;
        String v316 = v315;
        Map<String, String> attrs317 = new HashMap<String, String>();
        attrs317.put("channel", "web");
        attrs317.put("payload", v316);
        String v317 = attrs317.get("payload");
        Handler04Dispatcher.apply(v317);
    }
}
