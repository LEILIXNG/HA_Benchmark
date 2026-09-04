package com.habench.sqli1030.dao;

import com.habench.sqli1030.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {
    private String carried;

    public static void apply(String value) {
        Stage03 self = new Stage03();
        self.handle(value);
    }

    private void handle(String value) {
        String v301 = "order:" + value + ";";
        this.carried = v301;
        stage1();
    }

    private void stage1() {
        String v302 = this.carried;
        String v303 = "order:" + v302 + ";";
        Map<String, String> attrs304 = new HashMap<String, String>();
        attrs304.put("channel", "web");
        attrs304.put("payload", v303);
        String v304 = attrs304.get("payload");
        SinkHandler.execute(v304);
    }
}
