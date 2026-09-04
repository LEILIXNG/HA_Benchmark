package com.habench.sqli1010.service;

import com.habench.sqli1010.service.SinkHandler;

public final class Stage03 {

    public static void handle(String value) {
        String v301 = "order:" + value + ";";
        SinkHandler.execute(v301);
    }
}
