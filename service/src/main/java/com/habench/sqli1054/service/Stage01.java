package com.habench.sqli1054.service;

import com.habench.sqli1054.service.Handler02Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {

    public static void handle(String value) {
        Map<String, String> attrs101 = new HashMap<String, String>();
        attrs101.put("channel", "web");
        attrs101.put("payload", value);
        String v101 = attrs101.get("payload");
        String v102 = v101;
        Handler02Dispatcher.apply(v102);
    }
}
