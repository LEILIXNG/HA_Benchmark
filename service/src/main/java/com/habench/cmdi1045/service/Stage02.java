package com.habench.cmdi1045.service;

import com.habench.cmdi1045.service.SinkHandler;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        SinkHandler.execute(v201);
    }
}
