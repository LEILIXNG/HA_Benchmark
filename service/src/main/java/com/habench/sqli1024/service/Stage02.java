package com.habench.sqli1024.service;

import com.habench.sqli1024.service.SinkHandler;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        SinkHandler.execute(v201);
    }
}
