package com.habench.cmdi1032.web;

import com.habench.cmdi1032.web.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {

    public static void handle(String value) {
        Map<String, String> attrs1 = new HashMap<String, String>();
        attrs1.put("channel", "web");
        attrs1.put("payload", value);
        String v1 = attrs1.get("payload");
        String v2 = "order:" + v1 + ";";
        Stage01.handle(v2);
    }
}
