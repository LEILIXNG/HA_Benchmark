package com.habench.cmdi1062.dao;

import com.habench.cmdi1062.dao.Handler04Dispatcher;
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
        String v302 = "order:" + v301 + ";";
        cached = v302;
        stage1();
    }

    private void stage1() {
        String v303 = cached;
        String v304 = "order:" + v303 + ";";
        this.carried = v304;
        stage2();
    }

    private void stage2() {
        String v305 = this.carried;
        String v306 = v305;
        String v307 = "order:" + v306 + ";";
        this.carried = v307;
        stage3();
    }

    private void stage3() {
        String v308 = this.carried;
        Map<String, String> attrs309 = new HashMap<String, String>();
        attrs309.put("channel", "web");
        attrs309.put("payload", v308);
        String v309 = attrs309.get("payload");
        Map<String, String> attrs310 = new HashMap<String, String>();
        attrs310.put("channel", "web");
        attrs310.put("payload", v309);
        String v310 = attrs310.get("payload");
        cached = v310;
        stage4();
    }

    private void stage4() {
        String v311 = cached;
        Map<String, String> attrs312 = new HashMap<String, String>();
        attrs312.put("channel", "web");
        attrs312.put("payload", v311);
        String v312 = attrs312.get("payload");
        Map<String, String> attrs313 = new HashMap<String, String>();
        attrs313.put("channel", "web");
        attrs313.put("payload", v312);
        String v313 = attrs313.get("payload");
        Handler04Dispatcher.apply(v313);
    }
}
