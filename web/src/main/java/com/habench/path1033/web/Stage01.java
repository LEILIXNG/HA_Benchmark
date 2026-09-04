package com.habench.path1033.web;

import com.habench.path1033.web.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = value;
        Map<String, String> attrs102 = new HashMap<String, String>();
        attrs102.put("channel", "web");
        attrs102.put("payload", v101);
        String v102 = attrs102.get("payload");
        SinkHandler.execute(v102);
    }
}
