package com.habench.cmdi1045n.service;

import com.habench.cmdi1045n.service.SinkHandler;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        SinkHandler.execute(v201);
    }
}
