package com.habench.path1010.dao;

import com.habench.path1010.dao.SinkHandler;
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
        String v301 = value;
        String v302 = v301;
        cached = v302;
        stage1();
    }

    private void stage1() {
        String v303 = cached;
        Map<String, String> attrs304 = new HashMap<String, String>();
        attrs304.put("channel", "web");
        attrs304.put("payload", v303);
        String v304 = attrs304.get("payload");
        String v305 = v304;
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
        SinkHandler.execute(v308);
    }
}
