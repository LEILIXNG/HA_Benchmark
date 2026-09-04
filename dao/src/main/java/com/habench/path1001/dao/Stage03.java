package com.habench.path1001.dao;

import com.habench.path1001.dao.SinkHandler;
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
        cached = v301;
        stage1();
    }

    private void stage1() {
        String v302 = cached;
        String v303 = v302;
        String v304 = "order:" + v303 + ";";
        this.carried = v304;
        stage2();
    }

    private void stage2() {
        String v305 = this.carried;
        String v306 = v305;
        String v307 = v306;
        SinkHandler.execute(v307);
    }
}
