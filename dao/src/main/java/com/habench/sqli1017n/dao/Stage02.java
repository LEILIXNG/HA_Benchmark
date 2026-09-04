package com.habench.sqli1017n.dao;

import com.habench.sqli1017n.dao.Handler03Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {
    private static String cached;

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        String v202 = v201;
        cached = v202;
        stage1();
    }

    private static void stage1() {
        String v203 = cached;
        Map<String, String> attrs204 = new HashMap<String, String>();
        attrs204.put("channel", "web");
        attrs204.put("payload", v203);
        String v204 = attrs204.get("payload");
        Handler03Dispatcher.apply(v204);
    }
}
