package com.habench.cases.java_path_1001_n.web;

import com.habench.cases.java_path_1001_n.web.Sanitizer08;
import java.util.HashMap;
import java.util.Map;

public final class Step07 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Sanitizer08.apply(attributes.get("payload"));
    }
}
