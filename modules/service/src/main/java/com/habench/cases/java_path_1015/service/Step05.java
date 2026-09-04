package com.habench.cases.java_path_1015.service;

import com.habench.cases.java_path_1015.service.Step06;
import java.util.HashMap;
import java.util.Map;

public final class Step05 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Step06.apply(attributes.get("payload"));
    }
}
