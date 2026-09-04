package com.habench.path1028n.service;

import com.habench.path1028n.dao.Stage02;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        Map<String, String> attrs102 = new HashMap<String, String>();
        attrs102.put("channel", "web");
        attrs102.put("payload", v101);
        String v102 = attrs102.get("payload");
        Stage02.handle(v102);
    }
}
