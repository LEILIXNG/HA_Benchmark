package com.habench.path1006.dao;

import com.habench.path1006.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage05 {
    private String carried;

    public static void apply(String value) {
        Stage05 self = new Stage05();
        self.handle(value);
    }

    private void handle(String value) {
        Map<String, String> attrs501 = new HashMap<String, String>();
        attrs501.put("channel", "web");
        attrs501.put("payload", value);
        String v501 = attrs501.get("payload");
        this.carried = v501;
        stage1();
    }

    private void stage1() {
        String v502 = this.carried;
        Map<String, String> attrs503 = new HashMap<String, String>();
        attrs503.put("channel", "web");
        attrs503.put("payload", v502);
        String v503 = attrs503.get("payload");
        SinkHandler.execute(v503);
    }
}
