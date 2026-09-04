package com.habench.cases.java_sqli_1035.web;

import com.habench.cases.java_sqli_1035.web.Step03;
import java.util.HashMap;
import java.util.Map;

public final class Step02 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Step03.apply(attributes.get("payload"));
    }
}
