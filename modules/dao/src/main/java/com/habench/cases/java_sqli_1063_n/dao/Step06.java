package com.habench.cases.java_sqli_1063_n.dao;

import com.habench.cases.java_sqli_1063_n.dao.Step07;
import java.util.HashMap;
import java.util.Map;

public final class Step06 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Step07.apply(attributes.get("payload"));
    }
}
