package com.habench.sqli1003.web;

import com.habench.sqli1003.web.SinkHandler;

public final class Stage03 {

    public static void handle(String value) {
        String v301 = "order:" + value + ";";
        SinkHandler.execute(v301);
    }
}
