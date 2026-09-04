package com.habench.sqli1011.dao;

import com.habench.sqli1011.dao.Handler03Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = value;
        Map<String, String> attrs202 = new HashMap<String, String>();
        attrs202.put("channel", "web");
        attrs202.put("payload", v201);
        String v202 = attrs202.get("payload");
        Handler03Dispatcher.apply(v202);
    }
}
