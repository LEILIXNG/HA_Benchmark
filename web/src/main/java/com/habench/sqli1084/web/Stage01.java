package com.habench.sqli1084.web;

import com.habench.sqli1084.web.SinkHandler;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        String v102 = v101;
        SinkHandler.execute(v102);
    }
}
