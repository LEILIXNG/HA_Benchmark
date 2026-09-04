package com.habench.path1030.web;

import com.habench.path1030.web.SinkHandler;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        SinkHandler.execute(v101);
    }
}
