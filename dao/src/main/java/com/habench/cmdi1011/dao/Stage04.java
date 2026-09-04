package com.habench.cmdi1011.dao;

import com.habench.cmdi1011.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage04 {
    private String carried;

    public static void apply(String value) {
        Stage04 self = new Stage04();
        self.handle(value);
    }

    private void handle(String value) {
        String v401 = value;
        this.carried = v401;
        stage1();
    }

    private void stage1() {
        String v402 = this.carried;
        Map<String, String> attrs403 = new HashMap<String, String>();
        attrs403.put("channel", "web");
        attrs403.put("payload", v402);
        String v403 = attrs403.get("payload");
        Map<String, String> attrs404 = new HashMap<String, String>();
        attrs404.put("channel", "web");
        attrs404.put("payload", v403);
        String v404 = attrs404.get("payload");
        SinkHandler.execute(v404);
    }
}
