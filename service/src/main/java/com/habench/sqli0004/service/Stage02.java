package com.habench.sqli0004.service;

import com.habench.sqli0004.service.Handler03Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {
    private String carried;

    public static void apply(String value) {
        Stage02 self = new Stage02();
        self.handle(value);
    }

    private void handle(String value) {
        this.carried = value;
        stage1();
    }

    private void stage1() {
        String v201 = this.carried;
        Map<String, String> attrs202 = new HashMap<String, String>();
        attrs202.put("channel", "web");
        attrs202.put("payload", v201);
        String v202 = attrs202.get("payload");
        Handler03Dispatcher.apply(v202);
    }
}
