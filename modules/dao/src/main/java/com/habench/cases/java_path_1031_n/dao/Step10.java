package com.habench.cases.java_path_1031_n.dao;

import com.habench.cases.java_path_1031_n.dao.Step11;
import java.util.HashMap;
import java.util.Map;

public final class Step10 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Step11.apply(attributes.get("payload"));
    }
}
