package com.habench.sqli1012.service;

import com.habench.sqli1012.service.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {
    private String carried;

    public static void apply(String value) {
        Stage02 self = new Stage02();
        self.handle(value);
    }

    private void handle(String value) {
        Map<String, String> attrs201 = new HashMap<String, String>();
        attrs201.put("channel", "web");
        attrs201.put("payload", value);
        String v201 = attrs201.get("payload");
        Map<String, String> attrs202 = new HashMap<String, String>();
        attrs202.put("channel", "web");
        attrs202.put("payload", v201);
        String v202 = attrs202.get("payload");
        this.carried = v202;
        stage1();
    }

    private void stage1() {
        String v203 = this.carried;
        String v204 = v203;
        Map<String, String> attrs205 = new HashMap<String, String>();
        attrs205.put("channel", "web");
        attrs205.put("payload", v204);
        String v205 = attrs205.get("payload");
        SinkHandler.execute(v205);
    }
}
