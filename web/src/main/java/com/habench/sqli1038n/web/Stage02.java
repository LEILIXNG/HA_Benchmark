package com.habench.sqli1038n.web;

import com.habench.sqli1038n.service.Stage03;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = value;
        Map<String, String> attrs202 = new HashMap<String, String>();
        attrs202.put("channel", "web");
        attrs202.put("payload", v201);
        String v202 = attrs202.get("payload");
        Stage03.handle(v202);
    }
}
