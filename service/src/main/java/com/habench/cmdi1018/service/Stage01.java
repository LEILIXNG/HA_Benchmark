package com.habench.cmdi1018.service;

import com.habench.cmdi1018.service.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private String carried;

    public static void apply(String value) {
        Stage01 self = new Stage01();
        self.handle(value);
    }

    private void handle(String value) {
        String v101 = value;
        Map<String, String> attrs102 = new HashMap<String, String>();
        attrs102.put("channel", "web");
        attrs102.put("payload", v101);
        String v102 = attrs102.get("payload");
        this.carried = v102;
        stage1();
    }

    private void stage1() {
        String v103 = this.carried;
        String v104 = v103;
        String v105 = v104;
        SinkHandler.execute(v105);
    }
}
