package com.habench.cases.java_sqli_0001.dao;

import com.habench.cases.java_sqli_0001.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Step05 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        SinkHandler.execute(attributes.get("payload"));
    }
}
