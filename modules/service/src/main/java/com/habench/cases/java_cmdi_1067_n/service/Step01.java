package com.habench.cases.java_cmdi_1067_n.service;

import com.habench.cases.java_cmdi_1067_n.service.Step02;
import java.util.HashMap;
import java.util.Map;

public final class Step01 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Step02.apply(attributes.get("payload"));
    }
}
