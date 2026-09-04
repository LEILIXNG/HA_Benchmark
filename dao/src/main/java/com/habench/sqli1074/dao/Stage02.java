package com.habench.sqli1074.dao;

import com.habench.sqli1074.dao.SinkHandler;
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
        this.carried = v201;
        stage1();
    }

    private void stage1() {
        String v202 = this.carried;
        Map<String, String> attrs203 = new HashMap<String, String>();
        attrs203.put("channel", "web");
        attrs203.put("payload", v202);
        String v203 = attrs203.get("payload");
        SinkHandler.execute(v203);
    }
}
