package com.habench.sqli1008.dao;

import com.habench.sqli1008.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {
    private String carried;

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
        String v305 = "order:" + v304 + ";";
        SinkHandler.execute(v305);
    }
}
