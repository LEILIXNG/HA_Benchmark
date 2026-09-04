package com.habench.path1003n.dao;

import com.habench.path1003n.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {

    public static void handle(String value) {
        Map<String, String> attrs301 = new HashMap<String, String>();
        attrs301.put("channel", "web");
        attrs301.put("payload", value);
        String v301 = attrs301.get("payload");
        SinkHandler.execute(v301);
    }
}
