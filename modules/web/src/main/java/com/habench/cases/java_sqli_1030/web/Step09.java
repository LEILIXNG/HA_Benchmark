package com.habench.cases.java_sqli_1030.web;

import com.habench.cases.java_sqli_1030.web.Step10;
import java.util.HashMap;
import java.util.Map;

public final class Step09 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Step10.apply(attributes.get("payload"));
    }
}
