package com.habench.cmdi1023.web;

import com.habench.cmdi1023.web.Stage02;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {

    public static void handle(String value) {
        Map<String, String> attrs101 = new HashMap<String, String>();
        attrs101.put("channel", "web");
        attrs101.put("payload", value);
        String v101 = attrs101.get("payload");
        Map<String, String> attrs102 = new HashMap<String, String>();
        attrs102.put("channel", "web");
        attrs102.put("payload", v101);
        String v102 = attrs102.get("payload");
        Stage02.handle(v102);
    }
}
