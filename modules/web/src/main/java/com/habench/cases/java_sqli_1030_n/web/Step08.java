package com.habench.cases.java_sqli_1030_n.web;

import com.habench.cases.java_sqli_1030_n.web.Step09;
import java.util.HashMap;
import java.util.Map;

public final class Step08 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Step09.apply(attributes.get("payload"));
    }
}
