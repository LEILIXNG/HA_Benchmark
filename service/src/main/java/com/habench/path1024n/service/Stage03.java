package com.habench.path1024n.service;

import com.habench.path1024n.service.SinkHandler;
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
        Map<String, String> attrs302 = new HashMap<String, String>();
        attrs302.put("channel", "web");
        attrs302.put("payload", v301);
        String v302 = attrs302.get("payload");
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
        String v306 = "order:" + v305 + ";";
        Map<String, String> attrs307 = new HashMap<String, String>();
        attrs307.put("channel", "web");
        attrs307.put("payload", v306);
        String v307 = attrs307.get("payload");
        SinkHandler.execute(v307);
    }
}
