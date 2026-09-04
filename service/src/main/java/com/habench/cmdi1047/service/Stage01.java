package com.habench.cmdi1047.service;

import com.habench.cmdi1047.service.Handler02Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private String carried;

    public static void apply(String value) {
        Stage01 self = new Stage01();
        self.handle(value);
    }

    private void handle(String value) {
        Map<String, String> attrs101 = new HashMap<String, String>();
        attrs101.put("channel", "web");
        attrs101.put("payload", value);
        String v101 = attrs101.get("payload");
        this.carried = v101;
        stage1();
    }

    private void stage1() {
        String v102 = this.carried;
        String v103 = v102;
        String v104 = "order:" + v103 + ";";
        Handler02Dispatcher.apply(v104);
    }
}
