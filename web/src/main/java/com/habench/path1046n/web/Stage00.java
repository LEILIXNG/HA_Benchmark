package com.habench.path1046n.web;

import com.habench.path1046n.service.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {

    public static void handle(String value) {
        Map<String, String> attrs1 = new HashMap<String, String>();
        attrs1.put("channel", "web");
        attrs1.put("payload", value);
        String v1 = attrs1.get("payload");
        String v2 = v1;
        Stage01.apply(v2);
    }
}
