package com.habench.cases.java_sqli_1049_n.service;

import com.habench.cases.java_sqli_1049_n.service.Sanitizer06;
import java.util.HashMap;
import java.util.Map;

public final class Step05 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Sanitizer06.apply(attributes.get("payload"));
    }
}
