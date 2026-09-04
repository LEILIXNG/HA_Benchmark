package com.habench.cmdi1006.dao;

import com.habench.cmdi1006.dao.Handler04Dispatcher;
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
        Map<String, String> attrs301 = new HashMap<String, String>();
        attrs301.put("channel", "web");
        attrs301.put("payload", value);
        String v301 = attrs301.get("payload");
        String v302 = v301;
        this.carried = v302;
        stage1();
    }

    private void stage1() {
        String v303 = this.carried;
        Map<String, String> attrs304 = new HashMap<String, String>();
        attrs304.put("channel", "web");
        attrs304.put("payload", v303);
        String v304 = attrs304.get("payload");
        cached = v304;
        stage2();
    }

    private void stage2() {
        String v305 = cached;
        Map<String, String> attrs306 = new HashMap<String, String>();
        attrs306.put("channel", "web");
        attrs306.put("payload", v305);
        String v306 = attrs306.get("payload");
        cached = v306;
        stage3();
    }

    private void stage3() {
        String v307 = cached;
        String v308 = "order:" + v307 + ";";
        Handler04Dispatcher.apply(v308);
    }
}
