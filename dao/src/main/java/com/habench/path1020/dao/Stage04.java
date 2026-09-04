package com.habench.path1020.dao;

import com.habench.path1020.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage04 {
    private String carried;

    public static void apply(String value) {
        Stage04 self = new Stage04();
        self.handle(value);
    }

    private void handle(String value) {
        Map<String, String> attrs401 = new HashMap<String, String>();
        attrs401.put("channel", "web");
        attrs401.put("payload", value);
        String v401 = attrs401.get("payload");
        this.carried = v401;
        stage1();
    }

    private void stage1() {
        String v402 = this.carried;
        Map<String, String> attrs403 = new HashMap<String, String>();
        attrs403.put("channel", "web");
        attrs403.put("payload", v402);
        String v403 = attrs403.get("payload");
        SinkHandler.execute(v403);
    }
}
