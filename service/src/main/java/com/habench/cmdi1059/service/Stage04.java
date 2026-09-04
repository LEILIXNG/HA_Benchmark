package com.habench.cmdi1059.service;

import com.habench.cmdi1059.service.SinkHandler;
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
        String v402 = "order:" + v401 + ";";
        this.carried = v402;
        stage1();
    }

    private void stage1() {
        String v403 = this.carried;
        String v404 = v403;
        String v405 = v404;
        SinkHandler.execute(v405);
    }
}
