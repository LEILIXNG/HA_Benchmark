package com.habench.cases.java_sqli_1068.dao;

import com.habench.cases.java_sqli_1068.dao.Step08;
import java.util.HashMap;
import java.util.Map;

public final class Step07 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Step08.apply(attributes.get("payload"));
    }
}
