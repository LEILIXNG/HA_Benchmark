package com.habench.cases.java_sqli_1034.service;

import com.habench.cases.java_sqli_1034.dao.Gateway04;
import java.util.HashMap;
import java.util.Map;

public final class Step03 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Gateway04.apply(attributes.get("payload"));
    }
}
