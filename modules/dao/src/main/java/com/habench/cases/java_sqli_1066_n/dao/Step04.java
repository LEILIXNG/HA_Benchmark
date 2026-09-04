package com.habench.cases.java_sqli_1066_n.dao;

import com.habench.cases.java_sqli_1066_n.dao.Sanitizer05;
import java.util.HashMap;
import java.util.Map;

public final class Step04 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Sanitizer05.apply(attributes.get("payload"));
    }
}
