package com.habench.path1043.service;

import com.habench.path1043.service.SinkHandler;

public final class Stage06 {

    public static void handle(String value) {
        String v601 = "order:" + value + ";";
        SinkHandler.execute(v601);
    }
}
