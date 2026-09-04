package com.habench.cases.java_sqli_1066_n.dao;

import com.habench.cases.java_sqli_1066_n.dao.Step04;
import java.util.HashMap;
import java.util.Map;

public final class Step03 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Step04.apply(attributes.get("payload"));
    }
}
