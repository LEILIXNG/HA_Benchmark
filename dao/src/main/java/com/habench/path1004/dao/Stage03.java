package com.habench.path1004.dao;

import com.habench.path1004.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {

    public static void handle(String value) {
        String v301 = "order:" + value + ";";
        Map<String, String> attrs302 = new HashMap<String, String>();
        attrs302.put("channel", "web");
        attrs302.put("payload", v301);
        String v302 = attrs302.get("payload");
        SinkHandler.execute(v302);
    }
}
