package com.habench.cases.java_cmdi_1067_n.service;

import com.habench.cases.java_cmdi_1067_n.service.Step05;
import java.util.HashMap;
import java.util.Map;

public final class Step04 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Step05.apply(attributes.get("payload"));
    }
}
