package com.habench.cmdi1017.service;

import com.habench.cmdi1017.service.Handler02Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private String carried;

    public static void apply(String value) {
        Stage01 self = new Stage01();
        self.handle(value);
    }

    private void handle(String value) {
        String v101 = "order:" + value + ";";
        String v102 = v101;
        this.carried = v102;
        stage1();
    }

    private void stage1() {
        String v103 = this.carried;
        String v104 = v103;
        this.carried = v104;
        stage2();
    }

    private void stage2() {
        String v105 = this.carried;
        String v106 = "order:" + v105 + ";";
        Map<String, String> attrs107 = new HashMap<String, String>();
        attrs107.put("channel", "web");
        attrs107.put("payload", v106);
        String v107 = attrs107.get("payload");
        Handler02Dispatcher.apply(v107);
    }
}
