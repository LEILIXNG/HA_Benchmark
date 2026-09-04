package com.habench.cases.java_cmdi_1057.web;

import com.habench.cases.java_cmdi_1057.web.Sanitizer03;
import java.util.HashMap;
import java.util.Map;

public final class Step02 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Sanitizer03.apply(attributes.get("payload"));
    }
}
