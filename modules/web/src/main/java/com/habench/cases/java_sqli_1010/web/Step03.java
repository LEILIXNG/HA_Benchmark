package com.habench.cases.java_sqli_1010.web;

import com.habench.cases.java_sqli_1010.web.Sanitizer04;
import java.util.HashMap;
import java.util.Map;

public final class Step03 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Sanitizer04.apply(attributes.get("payload"));
    }
}
