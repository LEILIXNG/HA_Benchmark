package com.habench.cmdi1000n.dao;

import com.habench.cmdi1000n.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {
    private static String cached;

    public static void handle(String value) {
        String v301 = value;
        Map<String, String> attrs302 = new HashMap<String, String>();
        attrs302.put("channel", "web");
        attrs302.put("payload", v301);
        String v302 = attrs302.get("payload");
        cached = v302;
        stage1();
    }

    private static void stage1() {
        String v303 = cached;
        String v304 = "order:" + v303 + ";";
        SinkHandler.execute(v304);
    }
}
