package com.habench.path1006.service;

import com.habench.path1006.service.Handler04Dispatcher;
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
        Map<String, String> attrs302 = new HashMap<String, String>();
        attrs302.put("channel", "web");
        attrs302.put("payload", v301);
        String v302 = attrs302.get("payload");
        this.carried = v302;
        stage1();
    }

    private void stage1() {
        String v303 = this.carried;
        Map<String, String> attrs304 = new HashMap<String, String>();
        attrs304.put("channel", "web");
        attrs304.put("payload", v303);
        String v304 = attrs304.get("payload");
        String v305 = v304;
        Handler04Dispatcher.apply(v305);
    }
}
