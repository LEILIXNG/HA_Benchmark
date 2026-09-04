package com.habench.cmdi1043.dao;

import com.habench.cmdi1043.dao.Handler04Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {
    private String carried;

    public static void apply(String value) {
        Stage03 self = new Stage03();
        self.handle(value);
    }

    private void handle(String value) {
        String v301 = value;
        this.carried = v301;
        stage1();
    }

    private void stage1() {
        String v302 = this.carried;
        Map<String, String> attrs303 = new HashMap<String, String>();
        attrs303.put("channel", "web");
        attrs303.put("payload", v302);
        String v303 = attrs303.get("payload");
        Handler04Dispatcher.apply(v303);
    }
}
