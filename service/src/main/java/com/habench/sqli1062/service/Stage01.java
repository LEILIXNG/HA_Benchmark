package com.habench.sqli1062.service;

import com.habench.sqli1062.service.SinkHandler;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = value;
        String v102 = "order:" + v101 + ";";
        SinkHandler.execute(v102);
    }
}
