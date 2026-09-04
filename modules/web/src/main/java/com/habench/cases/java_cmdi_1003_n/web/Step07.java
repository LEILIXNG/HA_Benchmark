package com.habench.cases.java_cmdi_1003_n.web;

import com.habench.cases.java_cmdi_1003_n.service.Gateway08;
import java.util.HashMap;
import java.util.Map;

public final class Step07 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Gateway08.apply(attributes.get("payload"));
    }
}
