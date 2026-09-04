package com.habench.sqli1071.dao;

import com.habench.sqli1071.dao.Handler03Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {

    public static void handle(String value) {
        Map<String, String> attrs201 = new HashMap<String, String>();
        attrs201.put("channel", "web");
        attrs201.put("payload", value);
        String v201 = attrs201.get("payload");
        Handler03Dispatcher.apply(v201);
    }
}
