package com.habench.path1038n.service;

import com.habench.path1038n.service.SinkHandler;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = value;
        String v202 = "order:" + v201 + ";";
        SinkHandler.execute(v202);
    }
}
