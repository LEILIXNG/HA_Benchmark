package com.habench.sqli1012.web;

import com.habench.sqli1012.web.Handler01Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private String carried;

    public static void apply(String value) {
        Stage00 self = new Stage00();
        self.handle(value);
    }

    private void handle(String value) {
        Map<String, String> attrs1 = new HashMap<String, String>();
        attrs1.put("channel", "web");
        attrs1.put("payload", value);
        String v1 = attrs1.get("payload");
        this.carried = v1;
        stage1();
    }

    private void stage1() {
        String v2 = this.carried;
        String v3 = v2;
        String v4 = v3;
        Handler01Dispatcher.apply(v4);
    }
}
