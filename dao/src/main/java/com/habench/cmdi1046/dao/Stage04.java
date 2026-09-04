package com.habench.cmdi1046.dao;

import com.habench.cmdi1046.dao.Sanitizer05;
import java.util.HashMap;
import java.util.Map;

public final class Stage04 {
    private String carried;

    public static void apply(String value) {
        Stage04 self = new Stage04();
        self.handle(value);
    }

    private void handle(String value) {
        Map<String, String> attrs401 = new HashMap<String, String>();
        attrs401.put("channel", "web");
        attrs401.put("payload", value);
        String v401 = attrs401.get("payload");
        this.carried = v401;
        stage1();
    }

    private void stage1() {
        String v402 = this.carried;
        String v403 = v402;
        Sanitizer05.apply(v403);
    }
}
