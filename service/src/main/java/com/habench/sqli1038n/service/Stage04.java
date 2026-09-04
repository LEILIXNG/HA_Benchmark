package com.habench.sqli1038n.service;

import com.habench.sqli1038n.service.SinkHandler;

public final class Stage04 {

    public static void handle(String value) {
        String v401 = "order:" + value + ";";
        SinkHandler.execute(v401);
    }
}
