package com.habench.cmdi1012.dao;

import com.habench.cmdi1012.dao.Handler03Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {
    private static String cached;

    public static void handle(String value) {
        Map<String, String> attrs201 = new HashMap<String, String>();
        attrs201.put("channel", "web");
        attrs201.put("payload", value);
        String v201 = attrs201.get("payload");
        Map<String, String> attrs202 = new HashMap<String, String>();
        attrs202.put("channel", "web");
        attrs202.put("payload", v201);
        String v202 = attrs202.get("payload");
        cached = v202;
        stage1();
    }

    private static void stage1() {
        String v203 = cached;
        String v204 = "order:" + v203 + ";";
        String v205 = v204;
        Handler03Dispatcher.apply(v205);
    }
}
