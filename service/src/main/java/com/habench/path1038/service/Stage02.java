package com.habench.path1038.service;

import com.habench.path1038.service.SinkHandler;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = value;
        String v202 = "order:" + v201 + ";";
        SinkHandler.execute(v202);
    }
}
