package com.habench.path1032.service;

import com.habench.path1032.service.SinkHandler;
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
        String v305 = "order:" + v304 + ";";
        this.carried = v305;
        stage2();
    }

    private void stage2() {
        String v306 = this.carried;
        Map<String, String> attrs307 = new HashMap<String, String>();
        attrs307.put("channel", "web");
        attrs307.put("payload", v306);
        String v307 = attrs307.get("payload");
        String v308 = "order:" + v307 + ";";
        cached = v308;
        stage3();
    }

    private void stage3() {
        String v309 = cached;
        Map<String, String> attrs310 = new HashMap<String, String>();
        attrs310.put("channel", "web");
        attrs310.put("payload", v309);
        String v310 = attrs310.get("payload");
        SinkHandler.execute(v310);
    }
}
